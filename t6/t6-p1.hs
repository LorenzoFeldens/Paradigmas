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
createRects :: Int -> (Int,Int) -> (Int,Int) -> Int -> [(String,Rect)]
createRects mat (lin,col) (alt,lar) mar =
  [(createStyle mat (l,c) (lin,col),createRect mar (l,c) (alt,lar)) | l<-[0..(lin-1)], c<-[0..(col-1)]]
  
--Cria Retangulo
createRect :: Int -> (Int,Int) -> (Int,Int) -> Rect
createRect mar (l,c) (alt,lar) = ((fromIntegral(mar+c*(lar+1)),fromIntegral(mar+l*(alt+1))),fromIntegral(lar),fromIntegral(alt))
  
  
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
	
	
main :: IO ()
main = do
  let
    matiz = 210					--Matiz da Palheta
    (lin,col) = (9,5)			--Numero de Linhas e Colunas na Palheta
    (alt,lar) = (20,42)			--Altura e Largura de cada Cor
    mar = 1						--Margem entre as cores
    rects = createRects matiz (lin,col) (alt,lar) mar
    (w,h) = (mar+col*(lar+mar),mar+lin*(alt+mar))
  writeFile "colors.svg" $ writeRects (fromIntegral(w)) (fromIntegral(h)) rects