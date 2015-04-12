-- Aluno: Lorenzo Feldens

import Data.Char

--Exerc�cio 1

firstName :: String -> String
firstName str 
	| (head str) /= ' ' = (head str) : firstName (tail str)
	| otherwise = ""


--Exerc�cio 2

firstName' :: String -> String
firstName' str = takeWhile (/= ' ') str


--Exerc�cio 3

lastName :: String -> String
lastName str = reverse (firstName (reverse str))


--Exerc�cio 4

userName :: String -> String
userName str = [toLower x | x <- [head str]] ++ [toLower x | x <- lastName str]


--Exerc�cio 5

encodeName :: String -> String
encodeName str = concat (map (changeLetter) str)

changeLetter :: Char -> String
changeLetter c
	|c == 'a' || c=='A' = "4"
	|c == 'e' || c=='E' = "3"
	|c == 'i' || c=='I' = "1"
	|c == 'o' || c=='O' = "0"
	|c == 'u' || c=='U' = "00"
	|otherwise = [c]


--Exerc�cio 6

isElem :: Int -> [Int] -> Bool
isElem a x
	| x == [] = False
	| (head x) == a = True
	| otherwise = isElem a (tail x)


--Exerc�cio 7

numVogais :: String -> Int
numVogais str
	|str == [] = 0
	|toLower(head str) == 'a' = 1 + numVogais (tail str)
	|toLower(head str) == 'e' = 1 + numVogais (tail str)
	|toLower(head str) == 'i' = 1 + numVogais (tail str)
	|toLower(head str) == 'o' = 1 + numVogais (tail str)
	|toLower(head str) == 'u' = 1 + numVogais (tail str)
	|otherwise = numVogais (tail str)


--Exerc�cio 8

numCons :: String -> Int
numCons str = length (filter (\ x -> (x /= 'a') && (x /= 'e') && (x /= 'i') && (x /= 'o') && (x /= 'u') && (x /= ' ')) [toLower x | x <- str])


--Exerc�cio 9

isInt :: String -> Bool
isInt str
	|length (filter (\ x -> (x /= '0') && (x /= '1') && (x /= '2') && (x /= '3') && (x /= '4') && (x /= '5') && (x /= '6') && (x /= '7') && (x /= '8') && (x /= '9')) str) == 0 = True
	|otherwise = False


--Exerc�cio 10

strToInt :: String -> Int
strToInt str = sum (zipWith (*) (map (numStr) str) (reverse (map (10^) (take (length str) [0,1..]))))


numStr :: Char -> Int
numStr x
	|x == '0' = 0
	|x == '1' = 1
	|x == '2' = 2
	|x == '3' = 3
	|x == '4' = 4
	|x == '5' = 5
	|x == '6' = 6
	|x == '7' = 7
	|x == '8' = 8
	|x == '9' = 9