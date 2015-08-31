--Exercício 1
eleva2 :: [Int] -> [Int]
eleva2 [] = []
eleva2 (x:xs) = x^2 : eleva2 xs

--Exercício 2
contido :: Char -> String -> Bool
contido l x
	| x == "" = False
	| l == (head x) = True
	| otherwise = contido l (tail x)
	
--Exercício 3
semVogais :: String -> String
semVogais [] = []
semVogais (x:xs)
	| x == 'a' = semVogais xs
	| x == 'e' = semVogais xs
	| x == 'i' = semVogais xs
	| x == 'o' = semVogais xs
	| x == 'u' = semVogais xs
	| otherwise = x : semVogais xs
	
--Exercício 4
translate :: [(Float,Float)] -> [(Float,Float)]
translate [] = []
translate ((x1,x2):xs) = (x1+2,x2+2) : translate xs

--Exercício 5
geraTabela' :: Int -> [(Int,Int)]
geraTabela' x = aux 1 x

--Função Auxiliar
aux :: Int -> Int -> [(Int,Int)]
aux n x
	| n == x+1 = []
	| otherwise = (n,n^2) : aux (n+1) x