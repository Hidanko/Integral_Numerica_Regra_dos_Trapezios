package codigo;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Nemeth
 */
public class Calculo {

    int i, j;
    double h;
    int loop;
    double meio = 0;
    double ultimoResultado = 0;
    double resultado = 0;
    double TAXA_ERRO = 0.00001; 

    // Teste no Wolfran Alpha:
    // integrate sin (x^(1/3 )) from [0.0, 0.24]
    public Calculo() {
        /* Por algum motivo o programa não considerou a atribuição global */
        ultimoResultado = 0;
    }

    /* Alterar para a formula pedida */
    public double formula(double valor) {
        return Math.sin(Math.cbrt(valor));

    }

    // Exercício 2-A: Seno da raiz cúbica de X, limites em 0.0 e 0.24
    
    public void calculo() {

        /* Alterar limites superiores e inferiores */
        double limSuperior = 0.24;
        double limInferior = 0.0;
        loop = 1;

        do {
            h = (limSuperior - limInferior) / loop;
            System.out.println("LOOP:" + loop);
            System.out.println("h = " + h);

            /* Gerar o array */
            double array[] = new double[loop + 1];
            for (j = 0; j < loop + 1; j++) {
                array[j] = limInferior + (h * j);
            }
            
            for (double b : array) {
                System.out.println(b);
            }

            //Calcular o meio da formula 
            // Se o loop for igual a 1, ele vai ignorar o FOR e depois irá multiplicar 2 por 0 
            meio = 0.0;
            for (int k = 0; k < loop - 1; k++) {
                meio += formula(array[k + 1]);
            }
            /* Multiplicar por 2 */
            meio *= 2;

            /* Resolver */
            System.out.println("ArrayLength = " + array.length);
            resultado = (h / 2.0);
            resultado *= (formula(array[0]) + meio + formula(array[array.length - 1]));
            System.out.println("Resultado do loop " + loop + " foi de: " + resultado);

            array = null;
            loop++;
        } while (erro(resultado) > TAXA_ERRO);
        JOptionPane.showMessageDialog(null, "Resultado: "+resultado);
    }

    /* Arrumar */
    private double erro(double resultadoFuncao) {

        double E = (resultadoFuncao - ultimoResultado) / resultadoFuncao;
        ultimoResultado = resultadoFuncao;
        return E;
    }
}
