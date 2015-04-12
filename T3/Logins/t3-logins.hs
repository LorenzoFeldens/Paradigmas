-- Aluno: Lorenzo Feldens

import Data.Char

main :: IO ()
main = do
    strcontent <- readFile "nomes.csv"
    let strlist = lines strcontent
        strnew = map (userName) strlist
    writeFile "logins.csv" (unlines $ zipWith (++) strlist strnew)


firstName :: String -> String
firstName str = takeWhile (/= ' ') str

lastName :: String -> String
lastName str = reverse $ firstName (reverse str)

userName :: String -> String
userName str = "," ++ [toLower x | x <- [head str]] ++ [toLower x | x <- lastName str]