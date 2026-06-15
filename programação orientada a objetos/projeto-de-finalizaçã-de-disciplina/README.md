# 🏳️‍⚧️ InfoGênero — Sistema Educativo sobre Gênero e Sexualidade

> Projeto de Finalização do Módulo de Programação Orientada a Objetos  
> **Autor:** Elias Miguel Da Silva Maciel  
> **Linguagem:** Java | **Interface:** Swing

---

## 📌 Proposta do Sistema

O **InfoGênero** é um sistema desktop educativo com interface gráfica desenvolvido em Java com Swing. Seu objetivo é **combater a desinformação sobre gênero, sexualidade e identidade de pessoas trans**, oferecendo um ambiente acessível para consulta de terminologias, desmistificação de mitos e avaliação de conhecimento por meio de quizzes.

O sistema não utiliza banco de dados — todo o conteúdo é gerenciado em memória durante a execução.

---

## ✅ Requisitos Funcionais

| # | Requisito | Descrição |
|---|-----------|-----------|
| RF01 | Consultar termos | O usuário pode buscar e visualizar definições de termos relacionados a gênero e sexualidade |
| RF02 | Navegar por categorias | Os conteúdos são organizados em categorias (Identidade de Gênero, Orientação Sexual, Pessoas Trans) |
| RF03 | Mitos vs. Fatos | O sistema exibe afirmações comuns e esclarece se são mito ou fato, com explicação |
| RF04 | Quiz educativo | O usuário pode responder perguntas de múltipla escolha e receber feedback imediato |
| RF05 | Pontuação do quiz | O sistema registra e exibe a pontuação ao final do quiz |
| RF06 | Tratamento de erros | O sistema trata entradas inválidas e exibe mensagens de erro amigáveis ao usuário |

---

## 🏗️ Estrutura de Classes (POO)

```
Conteudo (classe abstrata)
├── Definicao
├── Mito
└── PerguntaQuiz
```

- **Herança:** `Definicao`, `Mito` e `PerguntaQuiz` herdam de `Conteudo`
- **Encapsulamento:** todos os atributos são `private` com getters/setters
- **Polimorfismo:** método `exibir()` sobrescrito em cada subclasse

---

## 🖥️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/elias-maciel-dev/infogenero.git
   ```
2. Compile o projeto:
   ```bash
   javac -d bin src/**/*.java
   ```
3. Execute:
   ```bash
   java -cp bin Main
   ```

> Requer **Java 11+**

---

## 📁 Estrutura de Pastas

```
infogenero/
├── src/
│   ├── model/
│   │   ├── Conteudo.java
│   │   ├── Definicao.java
│   │   ├── Mito.java
│   │   └── PerguntaQuiz.java
│   ├── view/
│   │   ├── TelaPrincipal.java
│   │   ├── TelaTermos.java
│   │   ├── TelaMitos.java
│   │   └── TelaQuiz.java
│   ├── controller/
│   │   └── SistemaController.java
│   └── Main.java
└── README.md
```

---

## 📚 Tecnologias

- Java (Swing para GUI)
- Paradigma: Orientação a Objetos

---

*Projeto acadêmico — Módulo de P.O.O*
