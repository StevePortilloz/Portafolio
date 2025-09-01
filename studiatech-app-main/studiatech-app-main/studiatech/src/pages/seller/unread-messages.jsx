import { useStateProvider } from "../../context/StateContext";
import { GET_UNREAD_MESSAGES, MARK_AS_READ_ROUTE } from "../../utils/constants";

import axios from "axios";
import Link from "next/link";
import React, { useEffect, useState } from "react";
import { useCookies } from "react-cookie";

function UnreadMessages() {
  const [cookies] = useCookies();
  const [{ userInfo }] = useStateProvider();
  const [messages, setMessages] = useState([]);
  useEffect(() => {
    const getUnreadMessages = async () => {
      const {
        data: { messages: unreadMessages },
      } = await axios.get(GET_UNREAD_MESSAGES, {
        withCredentials: true,
        headers: {
          Authorization: `Bearer ${cookies.jwt}`,
        },
      });
      setMessages(unreadMessages);
    };
    if (userInfo) {
      getUnreadMessages();
    }
  }, [userInfo]);

  const markAsRead = async (id) => {
    const response = await axios.put(
      `${MARK_AS_READ_ROUTE}/${id}`,
      {},
      {
        withCredentials: true,
        headers: {
          Authorization: `Bearer ${cookies.jwt}`,
        },
      }
    );
    if (response.status === 200) {
      const clonedMessages = [...messages];
      const index = clonedMessages.findIndex((message) => message.id === id);
      clonedMessages.splice(index, 1);
      setMessages(clonedMessages);
    }
  };

  return (
    <div className="min-h-[80vh] my-10 mt-0 px-32">
      <h3 className="mb-5 text-3xl font-semibold">Mensajes sin leer</h3>
      <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              <th scope="col" className="px-6 py-3">
                Mensaje
              </th>
              <th scope="col" className="px-6 py-3">
                Remitente
              </th>
              <th scope="col" className="px-6 py-3">
                Id Orden
              </th>
              <th scope="col" className="px-6 py-3">
                Marcar Leido
              </th>
              <th scope="col" className="px-6 py-3">
                Ver Conversacion
              </th>
            </tr>
          </thead>
          <tbody>
            {messages.map((message) => {
              return (
                <tr
                  className="bg-white dark:bg-gray-800 hover:bg-gray-50"
                  key={message.text}
                >
                  <th scope="row" className="px-6 py-4 ">
                    {message?.text}
                  </th>
                  <th scope="row" className="px-6 py-4 ">
                    {message?.sender?.fullName}
                  </th>
                  <th scope="row" className="px-6 py-4 font-medium">
                    {message.orderId}
                  </th>
                  <td className="px-6 py-4 ">
                    <Link
                      href="#"
                      onClick={(e) => {
                        e.preventDefault();
                        markAsRead(message.id);
                      }}
                      className="font-medium text-blue-600  hover:underline"
                    >
                      Marcar Leido
                    </Link>
                  </td>
                  <td className="px-6 py-4 ">
                    <Link
                      href={`/seller/orders/messages/${message.orderId}`}
                      className="font-medium text-blue-600  hover:underline"
                    >
                      Ver
                    </Link>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default UnreadMessages;
