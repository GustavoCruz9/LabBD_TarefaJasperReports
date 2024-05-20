# Projeto de Consulta e Relatórios de Produtos

Este projeto é uma aplicação web simples que permite consultar produtos, gerar relatórios em PDF utilizando JasperReports, e realizar operações CRUD na tabela de produtos. O projeto foi desenvolvido utilizando Spring Boot, Maven, JSP, JSTL e JTDS.

## Funcionalidades

- Consulta de produtos com filtro de quantidade em estoque.
- Operações CRUD (Criar, Ler, Atualizar, Deletar) na tabela de produtos.
- Geração de relatórios em PDF para produtos com estoque abaixo de um valor especificado.

## Estrutura da Tabela Produto

A tabela `Produto` possui os seguintes campos:

- `codigo` (INT): Código do produto (chave primária).
- `nome` (VARCHAR): Nome do produto.
- `valor_unitario` (DECIMAL): Valor unitário do produto.
- `qtd_estoque` (INT): Quantidade em estoque do produto.

## Requisitos

- Java 8 ou superior
- Maven 3.6.0 ou superior
- Banco de dados (SQL Server)
- Servidor de aplicação (por exemplo, Tomcat)

## Uso

1. Acesse a aplicação no seu navegador:
    ```
    http://localhost:8080
    ```

2. Utilize a interface para realizar consultas, operações CRUD e gerar relatórios.

## Desenvolvimento

### Dependências

As principais dependências do projeto são:

- Spring Boot
- Spring MVC
- Spring Data JPA
- JSTL
- JTDS
- JasperReports


