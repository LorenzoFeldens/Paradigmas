
-- Exercício 1
isEven :: Int -> Bool	
isEven n = mod n 2 == 0		--Verifica se um número é Par.


-- Exercício 2
somaquad :: Int -> Int -> Int
somaquad x y = (x*x)+(y*y)

-- Exercício 3
doubleFirst :: [Int] -> Int
doubleFirst x = (head x)*(head x)

-- Exercício 4
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads x y = head x == head y

-- Exercício 5
addMr :: [String] -> [String]
addMr x = map ("Mr. "++) x

-- Exercício 6
numSpaces :: String -> Int
numSpaces x = length (filter (==' ') x) 

-- Exercício 7
func1 :: [Float] -> [Float]
func1 x = map (\y -> 3*(y*y) + (2/y) + 1) x

-- Exercício 8
idades :: [Int] -> [Int]
idades x = filter (>1970) (map (2015-) x)

-- Exercício 9
serie :: Double -> [Double] -> Double
serie m n = sum (map (/m) n)

-- Exercício 10
charFound :: Char -> String -> Bool
charFound x n 
	| null n = False
	| head n == x = True
	| otherwise = charFound x (tail n)
		

-- Exercício 11
htmlListItems :: [String] -> [String]
htmlListItems x = map (\y -> "<LI>"++y++"</LI>") x

-- Exercício 12
	-- takeWhile (/= '@') "lfeldens@inf.ufsm.br"
	-- lfeldens

-- Exercício 13
nomeFem :: [String] -> [String]
nomeFem x = filter (\y -> last y == 'a') (map (\y -> takeWhile (/=' ') y) x)