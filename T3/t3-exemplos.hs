--Aluno: Lorenzo Feldens

--Exerc�cio 1

--Verifica a presen�a de espa�os em uma string

hasSpace :: String -> Bool
hasSpace str = any (' '==) str

hasSpace' :: String -> Bool
hasSpace' str 
	| all (/=' ') str = False
	| otherwise = True

--Verifica se h� um numero maior do que 'x' no vetor

hasGreater :: Int -> [Int] -> Bool
hasGreater x v
	| all (<x) v = False
	| otherwise = True

hasGreater' :: Int -> [Int] -> Bool
hasGreater' x v = any (>x) v


--Exerc�cio 2
--'$' pode ser utilizado como uma alternativa aos parenteses durante a atribui��o de argumentos a uma fun��o

exe1 :: Int -> [Int] -> [Int] -> [Int]
exe1 a v1 v2 = filter (>a) $ v1 ++ v2

exe2 :: Int -> [Int] -> Bool
exe2 a v = any odd $ map (*a) v


--Exerc�cio 3 

exe3 :: [Int] -> [Int]
exe3 v = map (f1.f2) v
	where
		f1 = (^2)
		f2 = (*2)

exe4 :: [String] -> [String]
exe4 str = map (f1.f2) str 
	where
		f1 = ("-->"++)
		f2 = (++"<--")