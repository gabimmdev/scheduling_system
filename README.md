[![Typing SVG](https://readme-typing-svg.herokuapp.com/?color=3CB371&size=35&center=true&vCenter=true&width=1000&lines=+API+de+Agendamento)](https://git.io/typing-svg)

Esta é uma API REST desenvolvida com **Java + Spring Boot** para gerenciar agendamentos simples de clientes.

### 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok (opcional)
- Maven

### ▶️ Como rodar localmente

1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/seu-repo.git
cd scheduling_system (se ja não estiver nela)
```
3. Abra no IntelliJ, VS Code ou outra IDE com suporte a Spring Boot.
4. Execute a aplicação (AgendamentoApplication.java) ou no terminal execute:
   ```bash
   ./mvnw spring-boot:run
   ```
6. Acesse o H2 Console (opcional):
<br> http://localhost:8080/h2-console <br>
JDBC URL: jdbc:h2:mem:agendadb

### 🔗 Endpoints principais
| Método | Rota                           | Descrição                    |
|--------|--------------------------------|------------------------------|
| GET    | `/agendamentos`                | Listar todos os agendamentos |
| POST   | `/agendamentos`                | Criar novo agendamento       |
| PUT    | `/agendamentos/{id}/confirmar` | Confirmar agendamento        |
| DELETE | `/agendamentos/{id}`           | Excluir agendamento          |

### 🗃️ Exemplo JSON
```json
{
  "cliente": "Maria Oliveira",
  "horario": "2025-04-10T14:00:00"
}
```
