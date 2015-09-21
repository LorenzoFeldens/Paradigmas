import Text.Printf

type Point     = (Float,Float)
type Square	   = (Point,Float)
type Hex	   = (Point,Point,Point,Point,Point,Point)

-- Gera quadrado SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeSquare :: (String,Square) -> String
writeSquare (style,((x,y),s)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y s s style
  
-- Gera codigo-fonte de arquivo SVG
-- concatenando uma lista de quadrados e seus atributos de estilo
writeSquares :: Float -> Float -> [(String,Square)] -> String 
writeSquares w h sq = 
  printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeSquare sq) ++ "</svg>"

--Cria os Quadrados com Estilos
createSquares :: Int -> [(String,Square)]
createSquares tam =
	[(createStyle x tam,createSquare x tam) | x<-[tam,(tam-1)..1]]

--Devolve a posicao do quadrado
posicao :: Int -> Int -> Int
posicao n tam
	|(tam-n)<=3 = tam-n
	|otherwise = posicao n (tam-4)
	
--Cria o Style de cada Quadrado
createStyle :: Int -> Int -> String
createStyle n tam = "fill:hsl("++show h++",100%,50%); stroke:black;"
	where
	h=alterColor n tam
	
--Seleciona a Matiz
alterColor :: Int -> Int -> Int
alterColor n tam
	|odd tam = 300-h*n
	|otherwise = h*n
	where
	h = 300`div`tam
  
--Cria Quadrado
createSquare :: Int -> Int -> Square
createSquare n tam = ((fromIntegral(posX n tam (posicao n tam)),fromIntegral(posY n tam (posicao n tam))),fromIntegral (fib n))

--Posicao X Quadrado
posX :: Int -> Int -> Int -> Int
posX n tam p
	|p == 0 = sumPre tam (n+4)
	|p == 1 = sumPre tam (n+1)
	|p == 2 = fib (n-1) + sumPre tam (n+2)
	|p == 3 = sumPre tam (n+3)

--Posicao Y Quadrado
posY :: Int -> Int -> Int -> Int
posY n tam p
	|p == 0 = sumPre tam (n+3)
	|p == 1 = sumPre tam (n+4)
	|p == 2 = sumPre tam (n+1)
	|p == 3 = fib (n-1) + sumPre tam (n+2)

--Soma dos Quadrados Anteriores da Posicao
sumPre :: Int -> Int -> Int
sumPre tam n
	|n>tam = 0
	|otherwise = (fib n+(sumPre tam (n+4)))

--Numero correspondente na sequencia de Fibonacci
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

-- Gera Poligono SVG 
writeHex :: (String,Hex) -> String
writeHex (style,((x1,y1),(x2,y2),(x3,y3),(x4,y4),(x5,y5),(x6,y6))) = 
  printf "<polygon points='%.3f,%.3f %.3f,%.3f %.3f,%.3f %.3f,%.3f %.3f,%.3f %.3f,%.3f' style='%s' />\n" 
		x1 y1 x2 y2 x3 y3 x4 y4 x5 y5 x6 y6 style
  
-- Gera codigo-fonte de arquivo SVG
-- concatenando uma lista de hexagonos e seus atributos de estilo
writeHexs :: Float -> Float -> [(String,Hex)] -> String 
writeHexs w h lis = 
  printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeHex lis) ++ "</svg>"

--Cria Hexagonos
createHex :: Int -> (Int,Int) -> [(String,Hex)]
createHex tam (lar,alt) = [(colorHex 0 (m+a`div`2) a,((fromIntegral n,fromIntegral m),(fromIntegral (n+tam),fromIntegral m),(fromIntegral (n+tam+h),fromIntegral 
		(m+a`div`2)),(fromIntegral (n+tam),fromIntegral (m+a)),(fromIntegral n,fromIntegral (m+a)),(fromIntegral (n-h),fromIntegral (m+a`div`2))))
		| n<-[0,(2*(tam+h))..(lar+tam+2*h)], m<-[0,a..(alt+a)] ] ++ [(colorHex 180 (m+a`div`2) a,((fromIntegral n,fromIntegral m),(fromIntegral (n+tam),fromIntegral m),(fromIntegral 
		(n+tam+h),fromIntegral (m+a`div`2)),(fromIntegral (n+tam),fromIntegral (m+a)),(fromIntegral n,fromIntegral (m+a)),(fromIntegral (n-h),fromIntegral 
		(m+a`div`2))))| n<-[(tam+h),((tam+h)+(2*(tam+h)))..(lar+tam+2*h)], m<-[(-1*a`div`2),(a`div`2)..(alt+a)] ]
	where
		a = floor (sqrt.fromIntegral $ (2*tam*tam))
		h = floor (sqrt.fromIntegral $ (tam*tam-(a`div`2)*(a`div`2)))

--Varia as cores
colorHex :: Int -> Int -> Int -> String
colorHex c n m 
	|n<m = "fill:hsl("++show (c)++",100%,50%); stroke:black;"
	|n<m*2 = "fill:hsl("++show (c+60)++",100%,50%); stroke:black;"
	|n<m*3 = "fill:hsl("++show (c+120)++",100%,50%); stroke:black;"
	|otherwise = colorHex c (n-m*3) m
	
main1 :: IO ()  			--Cria num_sq de Quadrados representando a Golden Spiral (Produzida a partir da sequencia de Fibonacci)
main1 = do
  let num_sq = 15				--Numero de Quadrados
  let sq = createSquares num_sq
  let (w,h) = (1+fib num_sq + fib (num_sq-1),1+fib num_sq)
  writeFile "colors3_1.svg" $ writeSquares (fromIntegral w) (fromIntegral h) sq
  
main2 :: IO ()					--Cria um Padrão de tamanho w x h composto Hexagonos de lado tam, sem repetir cores em formas adjacentes
main2 = do	
	let tam	= 10				--Tamanho Lado
	let (w,h) = (500,500)		--Tamanho Padrão
	let lis = createHex tam (w,h)
	writeFile "colors3_2.svg" $ writeHexs (fromIntegral w) (fromIntegral h) lis
	