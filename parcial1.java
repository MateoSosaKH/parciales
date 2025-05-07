package Parciales;
import java.util.Iterator;
public class Parcial1 {
    /*un arbol general arbol1 se considera "profundamente inferior" a otro arbol general arbol 2 cuando 
    se cumplen las siguientes dos reglas en todos los nodos coincidentes en posición de ambos arboles:
    1. el valor de cada nodo en arbol1 debe ser menor que el valor del nodo correspondiente en arbol2.
    2.a) Si ambos nodos tienen hijos la suma de los valores de los hijos de cada nodo en arbol1 debe ser menor que 
    la suma de los valores de los hijos del nodo correspondiente en arbol2.
    b) si ambos nodos son hojas: la condición se considera cumplida para esos nodos si se cumple la condición 1.
    si uno de los nodos es hoja y el otro no:
    c1) Si un nodo de un arbol1 es hoja y el nodo correspondiente en arbol 2 no es hoja entonces la condición se 
    considera cumplida para ese nodo si se cumple la condición 1.
    c2) Si un nodo de arbol 1 no es hoja y el nodo correspondiente en arbol2 es hoja, entonces arbol1 no es 
    profundamente inferior y el método debe devolver false.*/
    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol2.isEmpty()){
            return false;
        }
        if(arbol1.isLeaf() && arbol1.getData() < arbol2.getData()){
            return true;
        }
        if(arbol2.isLeaf() && !arbol2.isLeaf()){
            return false;
        }
        return nose(arbol1, arbol2);
    }
    
    public boolean nose(GeneralTree<Integer> a1, GeneralTree<Integer> a2){
        if(!(a1.getData() < a2.getData())){
            return false;
        }
        if(!suma(a1, a2)){
            return false;
        }
        Iterator<GeneralTree<Integer>> it = a1.getChildren().iterator();
        Iterator<GeneralTree<Integer>> it2 = a2.getChildren().iterator();
        while(it.hasNext() && it2.hasNext()){
            if(!nose(it.next(), it2.next())){
                return false;
            }
        }   
        
        return true;
    }
    
    public boolean suma (GeneralTree<Integer> a1, GeneralTree<Integer> a2){
        int i = 0;
        for(GeneralTree<Integer> hijo : a1.getChildren()){
            i++;
        }
        int d = 0;
        for(GeneralTree<Integer> hijo : a2.getChildren()){
            d++;
        }
        return i < d;
    }
    
}
