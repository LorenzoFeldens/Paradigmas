--
-- Este programa lê um arquivo CSV, com 2 dados por linha. Cada linha é transformada numa tupla. 
-- A lista de tuplas é passada para uma função que vai gerar uma longa string representando um
-- documento HTML.
--

main :: IO ()
main = do
    strcontent <- readFile infile
    let listofstrlist = map (splitOnChar ',') (lines strcontent)
        strtuplelist = map (\lis -> (head lis, last lis)) listofstrlist
    writeFile outfile (mkHtmlURLItemsDoc "Usuarios Cadastrados no NCC" strtuplelist)
    where 
    infile = "logins.csv"
    outfile = "output.html"


-- Esta função deve ser alterada para chamar outras funções que vão
-- construir o documento HTML
mkHtmlURLItemsDoc :: String -> [(String,String)] -> String
mkHtmlURLItemsDoc title lis = "<html><head><title>" ++ title ++ "</title></head><body><ul>" ++ unlines (map (links) lis) ++ "</ul></body></html>"

links :: (String,String) -> String
links lis = "<li><a href=http://www.inf.ufsm.br/~" ++ snd lis ++ ">" ++ fst lis ++ "</a></li>"


-- Decompoe string usando um caracter delimitador
splitOnChar :: Char -> String -> [String]
splitOnChar x y = auxSplitOnChar x y [[]]

auxSplitOnChar :: Char -> String -> [String] -> [String]
auxSplitOnChar x [] z = reverse (map reverse z)
auxSplitOnChar x (y:ys) (z:zs) = 
	if y == x then 
            auxSplitOnChar x ys ([]:(z:zs)) 
        else 
            auxSplitOnChar x ys ((y:z):zs)