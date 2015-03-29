--Aluno: Lorenzo Feldens

--Parte 1

--Gera uma lista com potências de 2, no expoente n até 0
geraPotencias :: Int -> [Int]
geraPotencias x = [2^x | x <- [x,(x-1)..0]]

--Adiciona um sufixo às strings de uma lista
addSuffix :: String -> [String] -> [String]
addSuffix su lis = [lis ++ su | lis <- lis]

--Cria uma lista com o ano de nascimento dos maiores de 20 anos
anosDeNascimento :: [Int] -> [Int]
anosDeNascimento n = [2015-n | n <- filter (>20) n] 

--Parte 2

--