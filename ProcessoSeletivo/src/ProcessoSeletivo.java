import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) throws Exception {
        
        System.out.println("PROCESSO SELETIVO: ");
        //selecaoCandidatos();
        System.out.println();
        System.out.println("CONTATO CANDIDATOS: ");
        for (String candidato : selecaoCandidatos()){
            ligarCandidato(candidato);
        }
    }

    public static void ligarCandidato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do { 
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso.");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na tentativa nº " + tentativasRealizadas + ".");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", após " + tentativasRealizadas + " tentativas realizadas.");
        }
    }

    //método auxiliar: simula se o candidato atendeu o telefonema.
    public static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    public static void imprimirSelecionados(){
        String[] candidatosSelecionados = selecaoCandidatos();
        System.out.println("CANDIDATOS SELECIONADOS: ");
        for (int idx = 0; idx < candidatosSelecionados.length; idx++) {
            System.out.println("Candidato nº " + (idx + 1) + " : " + candidatosSelecionados[idx]);
        }
    }

    public static String [] selecaoCandidatos() {
        
        String [] candidatos = {"Felipe", "Marcia", "Ana", "Julia", "Paulo", "Mirela", "João", "Pedro", "Miguel", "Rafael", "Clara", "Patricia"};

        int candidatosSelecionados = 0; 
        int candidatoAtual = 0; //indice array de candidatos.
        String [] selecionados = new String[5];
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                selecionados[candidatosSelecionados] = candidato; //adiciona o candidato selecionado ao array.
                candidatosSelecionados++;
            } else {
                System.out.println("O candidato " + candidato + " NÃO foi selecionado para a vaga.");
            }
            candidatoAtual++;
        }
        return selecionados;
    }

    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        } else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta.");
        } else {
            System.out.println("Aguardar próximos candidatos.");
        }
    }
}
