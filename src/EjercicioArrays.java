import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjercicioArrays {
    public static int NUM_ALUMNOS = 40;
    public static void main(String[] args) {
        //vector con las notas generadas
        Integer[] control = generarNotas();
        //Obtenemos la mayor y menor nota
        int maxNota = buscarMayorNota(control);
        int minNota = buscarMenorNota(control);
        
		int[] listaClase = generarListaClase();
		
       
      
        //Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        int indMinNota = notas.indexOf(minNota) + 1;
        int indMaxNota = notas.indexOf(maxNota) + 1;
        
        
       

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es : " + indMinNota);
        System.out.println("Indice del máximo es : " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + notas);
        
        
        
        //creamos el array de notas "practicas"
        int[] practicas = generarArrayPracticas();
        
        
        
        //Creamos el vector calificaciones
        float[] calificaciones = generarVectorCalificaciones(control, practicas); 		
        System.out.println("Prácticas      :" + Arrays.toString(practicas));
        System.out.println("Calificaciones :" + Arrays.toString(calificaciones));
        
        
        
        obtenerEstadisticas(control, calificaciones);
        
        
        
        
        
        //Aprobados y suspensos
        int[] aprobados = obtenerAprobados(calificaciones);
        int[] suspensos = obtenerSuspensos(calificaciones);      
        
        System.out.println("Resumen  de aprobados por nº de lista: " 
                + Arrays.toString(aprobados));
        System.out.println("Resumen  de aprobados por nº de lista: " 
                + Arrays.toString(suspensos));
    
        
        
     
        
        
        
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        double[] calif = generarCalificaciones();
        System.out.println("Nota antigua alumno nº4: " + calif[3]); 
        calif = insertarNuevoAlumno(calif);
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }
    
    public static double[] insertarNuevoAlumno(double[] calif) {
    	ArrayList<Double> califs = new ArrayList<Double>();
    	
    	for(int i = 0;i < 31;i++) {
    		califs.add(calif[i]);
    	}
    	califs.add(3,6.0);
    	for(int i = 0;i < califs.size();i++) {
    		calif[i] = califs.get(i);
    	}
    	return calif;
    }
    
    public static double[] generarCalificaciones() {
    	 double[] calif = new double[40];
         for (int j=0; j<31; j++){
             calif[j] = (int)(Math.random()*11);
         }
         return calif;
    }
    
    public static int[] obtenerAprobados(float[] calificaciones) {
    	int[] aprobados = new int[NUM_ALUMNOS];
    	int countAprobados = 0;
        for (int i=0; i<NUM_ALUMNOS; i++){
            if (calificaciones[i] >= 5){
            	aprobados[countAprobados] = i;
                countAprobados += 1;
            }
        }   
        
        return aprobados;
    }
    
    public static int[] obtenerSuspensos(float[] calificaciones) {
        int[] suspensos = new int[NUM_ALUMNOS];
        int countSuspensos = 0;
        for (int i=0; i<NUM_ALUMNOS; i++){
            if (calificaciones[i] < 5){
            	suspensos[countSuspensos] = i;
                 countSuspensos += 1;
            }
        }
        
        return suspensos;
    }
    
    public static Integer[] generarNotas() {
    	Integer[] control = new Integer[NUM_ALUMNOS]; 
    	//Genera notas random entre 1 y 10
        for(int i=0; i < control.length; i++){
            control[i] = (int)(Math.random()*11);
        }
        return control;
    }
    
    public static int buscarMayorNota(Integer[] control) {
        int maxNota = -1;
        for(int i=0; i<control.length; i++){
            if (control[i] > maxNota){
                maxNota = control[i];
            }
        }
        return maxNota;
    }
    
    public static int buscarMenorNota(Integer[] control) {
        int minNota = 11;
        for(int i=0; i<control.length; i++){
            if (control[i] < minNota){
                minNota = control[i];
            }
        }
        return minNota;
    }
    
    public static int[] generarListaClase() {
    	//creamos una lista de los alumnos de la clase
       int [] listaClase = new int[NUM_ALUMNOS];
        for (int i = 0; i < NUM_ALUMNOS; i++){
            listaClase[i] = i+1;
        }
        return listaClase;
    }
    
    public static int[] generarArrayPracticas() {
    	int[] practicas = new int[NUM_ALUMNOS];
        for(int i=0; i < practicas.length; i++){
            practicas[i] = (int)(Math.random()*11);
        }
        return practicas;
    }
    
    public static float[] generarVectorCalificaciones(Integer[] control,int[] practicas) {
    	float[] calificaciones = new float[NUM_ALUMNOS];
        for(int i = 0; i<control.length; i++){
            calificaciones[i] = 
                    (((float) control[i] 
                    + (float) practicas[i]) 
                    / 2);
        }
        return calificaciones;
    }
    
    
    public static void obtenerEstadisticas(Integer[] control,float[] calificaciones ) {
    	//Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        float[] estadistica = new float[10];
      
        for (int i=0; i<estadistica.length; i++){
            float count = 0;
            for (int j=0; j<control.length; j++){
                if ((i < calificaciones[j]) && ((i+1) >= calificaciones[j] )) {
                    count += 1;
                }
            }
            if (count != 0){
                estadistica[i] = ( (float)count / NUM_ALUMNOS);
            }else{ estadistica[i] = 0;}
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <=" 
                + (i+1) + " = " 
                + sol + "%");
        }
    }
    
    
     
}
