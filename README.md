# api-usuarios
Projeto de uma API onde conseguimos criar, editar, e listar usuários e seus endereços. 

# Diagrama de classes
![diagrama](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/cdf877ae-5372-4691-9805-2950ce6b33b2)


# Caminho para criar um usuário com endereço: POST http://localhost:8080/usuarios/salvar
Payload paa teste: {
    "nome" : "Usuario teste",
    "dataNascimento" : "2003-03-22",
    "endereco":{
        "logradouro":"Rua teste exemplo",
        "cep":"094512345",
        "numero":"34",
        "cidade":"São Paulo",
        "enderecoPrincipal":1,
        "estado":"SP"
        
        
    }
}

![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/aa1b2940-32d6-4766-a0f2-acaba3392854)



# Caminho para listar todos os usuários e seus endereços: GET http://localhost:8080/usuarios/listarusuarios
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/49d21c40-d1fb-4882-839a-2cdacf48558e)

# Caminho para listar um usuário especifico e seus endereços: GET http://localhost:8080/usuarios/listarusuario/1
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/50e102bb-0152-4785-a8d7-6a357a5ffe5b)

# Caso esse usuário não exista
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/4123ddee-4b0b-40c9-911f-f61289c62c13)



# Adicionar um novo endereço a lista de endereços pelo id do usuário: POST http://localhost:8080/usuarios/enderecoadicional/1
Paylod para teste:
{
    "logradouro" : "Rua Segundo teste de endereço",
    "cep" : "03395422",
     "numero":"808",
        "cidade":"São Paulo",
        "estado":"SP",
         "enderecoPrincipal":0,
    "usuario":{
        "nome":"Usuario teste",
        "dataNascimento":"2024-03-12"
    
        
    }
}


![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/78c4f384-aeac-4e8a-a849-93c4d7a91a5a)

# Lista com os dois endereços cadastrados
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/bc8a1478-4bac-4adf-ad1f-9836f38638d7)
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/bac12c7e-752c-4938-8d1c-5226a231bbee)




# Caminho para editar nome e data de nascimento de um usuário pelo id dele:
PUT http://localhost:8080/usuarios/editarusuario/1
Payload para teste:
{
    "nome" : "Vitoria Souto Machado",
    "dataNascimento" : "2000-10-08",
    "endereco":{
        "logradouro":"Rua Luisiana",
        "cep":"0440322",
        "numero":"808",
        "cidade":"São Paulo",
        "estado":"SP"
        
    }
}

# Alteração de nome feita
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/25907df3-d53a-4e71-88cb-3d1eedebf417)
# Nome alterado sendo listado
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/a493eaae-aea8-4b3e-b298-ac10b9f16aee)

# Alteração de data de nascimento feita
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/89928af1-a10a-4f61-9523-91be5e86b5c4)
# Data alterada sendo listada
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/cf2fe1e4-7f18-4304-b81c-50684494e66b)

# Caso o id não exista na base de dados
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/3e7f2068-215f-4578-b4aa-8eae356c3480)



# Caminho para editar apenas o endereço de um usuário pelo id do endereço: PUT http://localhost:8080/enderecos/editarendereco/1
Payload para teste: {
     "logradouro":"Teste com endereco atualizado",
        "cep":"12345678",
        "numero":"6",
        "cidade":"Rio de Janeiro",
        "enderecoPrincipal":1,
        "estado":"RJ",
    "usuario":{
        "nome":"Vitoria",
        "dataNascimento":"2024-03-12"
    
        
    }}
    
  # Atualização do endereço
  ![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/89c7fc56-733e-468a-b456-554e1dfb70de)
  # Listagem mostrando o endereço atualizado
  ![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/39a41e7f-43ae-4578-a55b-8134f7fab99d)



# Caminho para listar apenas um endereço, pelo id do endereço: GET http://localhost:8080/enderecos/listaendereco/1
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/bfc3deda-8953-47cf-8cb1-3be9df244bd5)

# Caso o id não exista na base
![image](https://github.com/VitoriaSouto06/api-usuarios/assets/70921240/1cd5995a-d3c1-4a5a-be9d-1a574819fabd)
