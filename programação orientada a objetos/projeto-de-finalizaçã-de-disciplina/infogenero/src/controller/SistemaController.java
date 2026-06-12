package controller;

import model.Conteudo;
import model.Definicao;
import model.Mito;
import model.PerguntaQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador principal do sistema.
 * Gerencia os dados em memória e oferece métodos de acesso à view.
 */
public class SistemaController {

    private List<Definicao> definicoes;
    private List<Mito> mitos;
    private List<PerguntaQuiz> perguntas;

    public SistemaController() {
        definicoes = new ArrayList<>();
        mitos = new ArrayList<>();
        perguntas = new ArrayList<>();
        carregarDados();
    }

    private void carregarDados() {
        // --- DEFINIÇÕES ---
        definicoes.add(new Definicao("Identidade de Gênero", "Identidade de Gênero",
                "É a percepção interna e individual que uma pessoa tem sobre si mesma em relação ao gênero. " +
                "Pode ser homem, mulher, não-binário, ou outras identidades. Não depende do sexo biológico."));

        definicoes.add(new Definicao("Pessoa Trans", "Pessoas Trans",
                "Termo guarda-chuva que engloba pessoas cuja identidade de gênero é diferente do sexo " +
                "atribuído ao nascer. Inclui mulheres trans, homens trans e pessoas não-binárias trans."));

        definicoes.add(new Definicao("Cisgênero", "Identidade de Gênero",
                "Pessoa cuja identidade de gênero corresponde ao sexo atribuído no nascimento. " +
                "Exemplo: alguém que nasceu com características femininas e se identifica como mulher."));

        definicoes.add(new Definicao("Orientação Sexual", "Orientação Sexual",
                "Diz respeito à atração afetiva, romântica e/ou sexual de uma pessoa por outras. " +
                "É independente da identidade de gênero. Exemplos: heterossexual, homossexual, bissexual, assexual."));

        definicoes.add(new Definicao("Não-Binário", "Identidade de Gênero",
                "Identidade de gênero que não se enquadra exclusivamente nas categorias de homem ou mulher. " +
                "Pessoas não-binárias podem se identificar como ambos, nenhum, ou algo além dessas categorias."));

        definicoes.add(new Definicao("Transição de Gênero", "Pessoas Trans",
                "Processo pelo qual uma pessoa trans adequa sua expressão de gênero à sua identidade. " +
                "Pode incluir mudança de nome, pronomes, vestimenta, e procedimentos médicos — mas não precisa incluir todos."));

        definicoes.add(new Definicao("Pronomes", "Identidade de Gênero",
                "Palavras usadas para se referir a uma pessoa. Respeitar os pronomes de uma pessoa trans " +
                "(ela/ela, ele/dele, elu/delu) é fundamental para o respeito à sua identidade."));

        // --- MITOS ---
        mitos.add(new Mito("Ser trans é uma doença mental.", "Pessoas Trans", true,
                "A Organização Mundial da Saúde (OMS) removeu a transexualidade da lista de doenças mentais " +
                "em 2018 (CID-11). Ser trans é uma variação humana natural da identidade de gênero."));

        mitos.add(new Mito("Identidade de gênero e orientação sexual são a mesma coisa.", "Identidade de Gênero", true,
                "São conceitos distintos. Identidade de gênero é sobre quem você É (homem, mulher, não-binário). " +
                "Orientação sexual é sobre por quem você se SENTE ATRAÍDO. Uma mulher trans pode ser hétero, lésbica, bi, etc."));

        mitos.add(new Mito("Crianças trans são influenciadas pelos pais.", "Pessoas Trans", true,
                "Pesquisas mostram que crianças trans persistem em sua identidade de gênero independentemente " +
                "da postura dos pais. Negar a identidade de uma criança trans causa danos psicológicos comprovados."));

        mitos.add(new Mito("Pessoas trans existem em todas as culturas e épocas da história.", "Pessoas Trans", false,
                "Verdade. Registros de pessoas com identidades de gênero diversas existem em civilizações antigas " +
                "do Egito, Roma, Índia, povos indígenas americanos (Two-Spirit), entre muitas outras culturas."));

        mitos.add(new Mito("Respeitar pronomes de pessoas trans é apenas 'modismo'.", "Identidade de Gênero", true,
                "O uso correto de pronomes é um ato de respeito básico. O desrespeito intencional aos pronomes " +
                "de uma pessoa trans é considerado uma forma de violência psicológica e pode causar danos à saúde mental."));

        // --- QUIZ ---
        perguntas.add(new PerguntaQuiz(
                "O que é identidade de gênero?",
                "Identidade de Gênero",
                new String[]{
                        "O sexo biológico de uma pessoa",
                        "A percepção interna sobre o próprio gênero",
                        "A orientação sexual de uma pessoa",
                        "O gênero que os pais escolhem para o filho"
                }, 1));

        perguntas.add(new PerguntaQuiz(
                "Em que ano a OMS removeu a transexualidade da lista de doenças mentais?",
                "Pessoas Trans",
                new String[]{
                        "2000",
                        "2010",
                        "2018",
                        "2023"
                }, 2));

        perguntas.add(new PerguntaQuiz(
                "O que significa ser cisgênero?",
                "Identidade de Gênero",
                new String[]{
                        "Ser atraído pelo mesmo gênero",
                        "Ter identidade de gênero diferente do sexo de nascimento",
                        "Ter identidade de gênero que corresponde ao sexo de nascimento",
                        "Não se identificar com nenhum gênero"
                }, 2));

        perguntas.add(new PerguntaQuiz(
                "Identidade de gênero e orientação sexual são a mesma coisa?",
                "Identidade de Gênero",
                new String[]{
                        "Sim, sempre andam juntas",
                        "Não, são conceitos completamente distintos",
                        "Só são diferentes em pessoas trans",
                        "Depende da cultura do país"
                }, 1));

        perguntas.add(new PerguntaQuiz(
                "O que é uma pessoa não-binária?",
                "Identidade de Gênero",
                new String[]{
                        "Uma pessoa que não tem gênero definido pela ciência",
                        "Uma pessoa que se identifica como homem e mulher ao mesmo tempo, sempre",
                        "Uma pessoa cuja identidade de gênero não se enquadra exclusivamente em homem ou mulher",
                        "Uma pessoa que ainda não decidiu seu gênero"
                }, 2));
    }

    // --- ACESSO AOS DADOS ---

    public List<Definicao> getDefinicoes() {
        return new ArrayList<>(definicoes);
    }

    public List<Mito> getMitos() {
        return new ArrayList<>(mitos);
    }

    public List<PerguntaQuiz> getPerguntas() {
        return new ArrayList<>(perguntas);
    }

    public List<Definicao> buscarDefinicoes(String termo) {
        if (termo == null || termo.isBlank()) {
            return getDefinicoes();
        }
        String termoBusca = termo.toLowerCase().trim();
        return definicoes.stream()
                .filter(d -> d.getTermo().toLowerCase().contains(termoBusca) ||
                             d.getDescricao().toLowerCase().contains(termoBusca))
                .collect(Collectors.toList());
    }

    public List<String> getCategorias() {
        return definicoes.stream()
                .map(Conteudo::getCategoria)
                .distinct()
                .collect(Collectors.toList());
    }
}
