import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)

-- Gera retangulo SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeRect :: (String,Rect) -> String 
writeRect (style,((x,y),w,h)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera codigo-fonte de arquivo SVG 
-- concatenando uma lista de retangulos e seus atributos de estilo
writeRects :: Float -> Float -> [(String,Rect)] -> String 
writeRects w h rs = 
  printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg' style='background: grey'>\n" w h 
      ++ (concatMap writeRect rs) ++ "</svg>"

--Cria os Retangulos com Estilos
createRects :: Int -> [Int] -> (Int,Int) -> (Int,Int) -> Int -> Int -> Int -> Int -> Int -> [(String,Rect)]
createRects n_mats mats (lin,col) (alt,lar) mar mar_p w_p h_p n_p=
  [(createStyle (mats!!mat) (l,c) (lin,col),createRect n_mats mat mar (l,c) (alt,lar) (lin,col) mar_p w_p h_p n_p)| l<-[0..(lin-1)], c<-[0..(col-1)], mat<-[0..(n_mats-1)]]
  
--Cria Retangulo
createRect :: Int -> Int -> Int -> (Int,Int) -> (Int,Int) -> (Int,Int) -> Int -> Int -> Int -> Int -> Rect
createRect n_mats mat mar (l,c) (alt,lar) (lin,col) mar_p w_p h_p n_p= ((fromIntegral(x),fromIntegral(y)),fromIntegral(lar),fromIntegral(alt))
	where
		lm=mat`div`n_p
		cm=mat-lm*n_p
		h=h_p+mar_p
		w=w_p+mar_p
		x=(mar+c*(lar+1))+w*cm
		y=(mar+l*(alt+1))+h*lm
  
  
--Cria o Style de cada Retangulo
createStyle :: Int -> (Int,Int) -> (Int,Int) -> String
createStyle mat (l,c) (lin,col) = "fill:hsl("++show mat++","++show s++"%,"++show b++"%)"
	where
		s=selectSat c col
		b=selectBri l lin
	
--Define a Saturação
selectSat :: Int -> Int -> Int
selectSat c col = 100 - (c*100`div`(col-1))

--Define o Brilho
selectBri :: Int -> Int -> Int
selectBri l lin = 100 - (l*100`div`(lin-1))

--Calcula o tamanho de cada Palheta
sizePal :: Int -> (Int,Int) -> (Int,Int) -> Int -> (Int,Int,Int)
sizePal num_matizes (lin,col) (alt,lar) mar = (w_p,h_p,n_p)
	where
		n_p = ceiling((sqrt.fromIntegral $ num_matizes))
		w_p = mar+col*(lar+mar)
		h_p = mar+lin*(alt+mar)
	
main :: IO ()
main = do
  let  num_matizes = 10 								--Numero de Palhetas
  let  matizes = [0,36,72,108,144,180,216,252,288,360]  --Numero correspondente a matiz de cada uma das palhetas
  let  (lin,col) = (9,5)								--Numero de Linhas e Colunas de cada Palheta
  let  (alt,lar) = (20,42)								--Altura e Largura de cada Cor
  let  mar = 1  										--Margem entre as cores
  let  mar_p = 50										--Margem entre Palhetas
  let  (w_p,h_p,n_p) = sizePal num_matizes (lin,col) (alt,lar) mar
  let  (w,h) = (w_p*n_p+mar_p*(n_p-1),h_p*n_p+mar_p*(n_p-1))
  let  rects = createRects num_matizes matizes (lin,col) (alt,lar) mar mar_p w_p h_p n_p
  
  writeFile "colors2.svg" $ writeRects (fromIntegral(w)) (fromIntegral(h)) rects