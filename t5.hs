
-- Exercício 1
addSuffix :: String -> [String] -> [String]
addSuffix suf str = [x ++ suf | x <- str]

-- Exercício 2
addSuffix' :: String -> [String] -> [String]
addSuffix' suf [] = []
addSuffix' suf (x:xs) = (x ++ suf) : addSuffix' suf xs

-- Exercício 3
countShorts :: [String] -> Int
countShorts lis = numWords 0 lis

-- Função Auxiliar Ex 3
numWords :: Int -> [String] -> Int
numWords n [] = n
numWords n (x:xs)
	| (length x) < 5 = numWords (n+1) xs
	| otherwise =  numWords n xs
	
-- Exercício 4
countShorts' :: [String] -> Int
countShorts' lis = length ([x | x <- lis, (length x) < 5])

-- Exercício 5
ciclo :: Int -> [Int] -> [Int]
ciclo 0 lis = []
ciclo n lis = lis ++ ciclo (n-1) lis

-- Exercício 6
combine :: [Int] -> [String] -> [(Int,String)]
combine [] lis = []
combine lis [] = []
combine (x:xs) (y:ys) = (x,y) : combine xs ys

-- Exercício 7
numera :: [String] -> [(Int,String)]
numera lis = numera' lis 1

--Função Auxiliar Ex 7
numera' :: [String] -> Int -> [(Int,String)]
numera' [] n = []
numera' (x:xs) n = (n,x) : numera' xs (n+1)

-- Exercício 8
-- a) Cria uma tupla que seleciona os elementos
-- pares de 1 a 5 e caso sejam pares, combina com
-- elementos impares a partir do próximo numero
-- após x até 6.
--
-- b) Cria uma lista de Strings que contém todas as
-- possibilidades de junções de Strings de 'a' com as
-- de 'b'.
--
-- c) Filtra as vogais de 'paralelepipedo', colocando-as
-- em uma String, separadas por '-'.

-- Exercício 9
crossProduct :: [a] -> [b] -> [(a,b)]
crossProduct [] ys = []
crossProduct (x:xs) ys = pairWithAll x ys ++ crossProduct xs ys

pairWithAll :: a -> [b] -> [(a,b)]
pairWithAll x [] = []
pairWithAll x (y:ys) = (x,y) : pairWithAll x ys 

-- Exercício 10
genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)]
genRects 0 (x,y) = [((fromIntegral x),(fromIntegral y),5.5,5.5)]
genRects n (x,y) = (genRects (n-1) (x,y)) ++ [(((fromIntegral x) + (fromIntegral n)*5.5),(fromIntegral y),5.5,5.5)]

-- Exercício 11
func :: [(Int,Int)] -> ([Int],[Int])
func lis = (aux1 lis, aux2 lis)

--Função Auxiliar 1 Ex 11
aux1 :: [(Int,Int)] -> [Int]
aux1 [] = []
aux1 ((x,y):xs) = x : aux1 xs

--Função Auxiliar 2 Ex 11
aux2 :: [(Int,Int)] -> [Int]
aux2 [] = []
aux2 ((x,y):xs) = y : aux2 xs

-- Exercício 12
func' :: [(Int,Int)] -> ([Int],[Int])
func' lis = ([fst x | x <- lis],[snd y | y <- lis])

-- Exercício 13
func'' :: [(Int,Int)] -> ([Int],[Int])
func'' lis = (map fst lis, map snd lis)
