package dinamicas;

//class NodoArbol2{
//	
//	public NodoArbol2 LI;
//	public int claveart;
//	public NodoArbol2 LD;
//}

public class Arbol2 {

//	public static NodoArbol Raiz=null;
//	public static int cuenta=0, total=0;
//
//
//	public static boolean InsertaABB(int clave,  NodoArbol nodo)
//	{
//		if (clave < nodo.getInfo())
//		{
//			if (nodo.LI==null)
//			{
//				NodoArbol2 nuevo=CreaNodo(clave);
//				nodo.LI=nuevo;
//				System.out.println("Se inserto "+clave);
//				return true;
//			}
//			else
//			{
//				InsertaABB(clave,  nodo.LI);
//			}
//		}
//		else
//		{
//			if (clave>nodo.claveart)
//			{
//				if (nodo.LD==null)
//				{
//					NodoArbol2 nuevo=CreaNodo(clave);
//					nodo.LD=nuevo;
//					System.out.println("Se inserto "+clave);
//					return true;		
//				}
//				else
//				{
//					InsertaABB(clave, nodo.LD);
//				}
//			}
//
//
//		}
//		return false;
//	}
//
//
//	public static NodoArbol2 CreaNodo(int clave)
//	{
//		NodoArbol2 nvo= new NodoArbol2();
//		nvo.claveart=clave;
//
//		nvo.LD=null;
//		nvo.LI=null;
//		return nvo;
//	}
//
//	public static boolean Busca(int dato, NodoArbol2 nodo)
//	{
//		if (nodo!=null)	
//		{
//			if (nodo.claveart==dato)
//			{
//				return true;
//			}
//			else
//			{
//				if (dato>nodo.claveart)
//				{
//					Busca(dato,nodo.LD);
//				}
//				else
//					if (dato<nodo.claveart)
//					{
//						Busca(dato,nodo.LI);  
//					}
//			}
//		}
//
//		return false;
//
//	}
//	public static void main(String args[]) throws IOException
//	{
//
//
//
//		NodoArbol2 nvo=CreaNodo(80);
//		Raiz=nvo;
//		System.out.println("Se inserto "+Raiz.claveart);
//
//		InsertaABB(90,Raiz);
//
//		InsertaABB(50,Raiz);
//		InsertaABB(55,Raiz);
//		InsertaABB(70,Raiz);
//
//		InsertaABB(35,Raiz);
//
//
//		InsertaABB( 100,Raiz);
//		InsertaABB(115,Raiz);
//		InsertaABB(65,Raiz);
//		InsertaABB(45,Raiz);
//		InsertaABB(120,Raiz);
//		InsertaABB(95,Raiz);
//		InsertaABB(40,Raiz);
//		System.out.println("Recorrido inorden");
//		inorden(Raiz);
//		System.out.println("Cuenta "+cuenta);
//		System.out.println("Recorrido preorden");
//		preorden(Raiz);
//		System.out.println("Recorrido postorden");
//		postorden(Raiz);
//		//System.out.println("DATO A BORRAR ");
//		//String Dato=Leer.dato();
//		//Raiz=BorraABB(Raiz,Dato);
//
//		System.out.println("Recorrido inorden 2");
//		inorden(Raiz); 
//		System.out.println("Recorrido postorden 2");
//		postorden(Raiz);
//		suma(Raiz);
//		System.out.println("total  "+total);
//
//	}
//
//	public static void inorden(NodoArbol2 nodo)
//	{ 
//		if (nodo!=null)
//		{
//			inorden(nodo.LI);
//
//			System.out.println(nodo.claveart);
//
//			inorden(nodo.LD);
//			cuenta++;	
//		}
//
//	}
//
//	public static void preorden(NodoArbol2 nodo)
//	{
//		if (nodo!=null)
//		{
//			System.out.println(nodo.claveart);
//			preorden(nodo.LI);
//			preorden(nodo.LD);
//
//		}
//	}
//
//	public static void postorden(NodoArbol2 nodo)
//	{
//		if (nodo!=null)
//		{
//			postorden(nodo.LI);
//			postorden(nodo.LD);
//			System.out.println(nodo.claveart);
//		}
//	}
//
//
//
//
//	public static void suma(NodoArbol2 nodo)
//	{
//		if (nodo!=null)
//		{
//
//			suma(nodo.LI);
//			total=total+nodo.claveart;
//			suma(nodo.LD);
//			total=total+nodo.claveart;
//
//		}
//	}		

}
