# 🏦 Acutis - Backend

Este é o backend da aplicação **Acutis**, um sistema de gerenciamento de usuários, agências bancárias, contas e transações. Desenvolvido com **Kotlin + Quarkus**, utiliza um banco de dados PostgreSQL containerizado com Docker.

---

## 🚀 Tecnologias

- [Kotlin](https://kotlinlang.org/)
- [Quarkus](https://quarkus.io/)
- [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)
- SDK Java **21**

---

## ⚙️ Requisitos

- [Java SDK 21+](https://jdk.java.net/21/)
- [Docker](https://www.docker.com/)
- [Gradle](https://gradle.org/) (utiliza o wrapper incluso)

---

## 📦 Build do Projeto

Para compilar o projeto:

```bash
./gradlew clean build
```

---

## ▶️ Executar em modo dev

Para rodar o backend em modo de desenvolvimento com hot reload:

```bash
./gradlew quarkusDev
```

---

## 🛢️ Subir o banco de dados com Docker

1. Navegue até o diretório de recursos:

```bash
cd develop-resources
```

2. Inicie o banco de dados PostgreSQL com:

```bash
docker-compose up --build
```

---

## 🧪 Endpoints e Testes

Os endpoints seguem o padrão REST e estarão disponíveis em:  
```
http://localhost:8080
```

Utilize ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para testar.

---

## 📝 Organização

O projeto segue uma estrutura modular por recurso:

```
src/
├── main/
│   ├── kotlin/
│   │   └── com.acutis/
│   │       ├── bancos/
│   │       ├── agencias/
│   │       ├── usuarios/
│   │       ├── contas/
│   │       └── transacoes/
│   └── resources/
├── test/
```

---

## 👨‍💻 Autor

Desenvolvido para o desafio técnico da **Acutis**.  
Feito com 💙 por **Iury Azevedo**.

---

## 📄 Licença

Este projeto é de uso privado e acadêmico. Direitos reservados.
