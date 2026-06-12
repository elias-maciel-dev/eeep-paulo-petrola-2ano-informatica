class Pessoa:
    def __init__(self, nome, fone, cpf):
        self.nome = nome
        self.fone = fone
        self.cpf = cpf

    def apresentar(self):
        print(f"Nome: {self.nome}")
        print(f"Fone: {self.fone}")
        print(f"CPF: {self.cpf}")


class Aluno(Pessoa):
    def __init__(self, nome, fone, cpf, matricula):
        super().__init__(nome, fone, cpf)
        self.matricula = matricula

    def aprender(self):
        print(f"{self.nome} está aprendendo.")

class Professor(Pessoa):
    def __init__(self, nome, fone, cpf, titulo):
        super().__init__(nome, fone, cpf)
        self.titulo = titulo

    def ensinar(self):
        print(f"{self.nome} está ensinando.")

class Funcionario(Pessoa):
    def __init__(self, nome, fone, cpf, cod, funcao):
        super().__init__(nome, fone, cpf)
        self.cod = cod
        self.funcao = funcao

    def desempenhar_funcao(self):
        print(f"{self.nome} trabalha como {self.funcao}")

class Responsavel:
    def __init__(self, nome, aluno):
        self.nome = nome
        self.aluno = aluno

    def mostrar_aluno(self):
        print(f"{self.nome} é responsável por {self.aluno.nome}")

if __name__ == "__main__":
    aluno = Aluno(
        "Elias",
        "889999999",
        "123456789",
        "2025001"
    )

    professor = Professor(
        "Carlos",
        "887777777",
        "987654321",
        "Mestre"
    )

    funcionario = Funcionario(
        "João",
        "886666666",
        "111222333",
        1,
        "Secretário"
    )

    responsavel = Responsavel(
        "Maria",
        aluno
    )

    aluno.apresentar()
    aluno.aprender()
    print()
    professor.apresentar()
    professor.ensinar()
    print()
    funcionario.apresentar()
    funcionario.desempenhar_funcao()
    print()
    responsavel.mostrar_aluno()
