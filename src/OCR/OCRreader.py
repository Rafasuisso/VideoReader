import cv2
import numpy as np
import math
from matplotlib import pyplot as plt


VideoFile = "vid4.mp4"
cap = cv2.VideoCapture(VideoFile);
frameRate = cap.get(5) #frame rate
while True:
    #frame atual
    frameId = cap.get(1) 
    #Captura o frame
    ret, frame = cap.read()

    #Define o range de cor verde
    lower_green = np.array([30,0,155])
    upper_green = np.array([90,255,255])

    #Seleciona o Frame a cada segundo
    if(frameId % math.floor(frameRate)==0):
        #Recorta a imagem no canto superior esquerdo
        crop_img = frame[0:150, 300:600]

       
        #Converte a imagem para HSV
        hsv =cv2.cvtColor(crop_img, cv2.COLOR_BGR2HSV)
       
        # Mascara para pegar somente os valores verde
        mask = cv2.inRange(hsv, lower_green, upper_green)

        #aplicassão do filtro Gaussiano
        mask = cv2.GaussianBlur(mask, (5, 5), 0)

        #encontrar os contornos na imagem
        ctrs = cv2.findContours(mask.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

        #Obter retangulos contendo cada contorno
       # rects = [cv2.boundingRect(ctr) for crt in ctrs]
        
        #Mostra a imagem na tela
        cv2.imshow('cropped', crop_img)
        #cv2.imshow('Hsv', hsv)
        cv2.imshow('Mask', mask)

    #gray = cv2.cvtColor(crop_img, cv2.COLOR_BGR2GRAY)
    cv2.imshow('frame', frame)
    #cv2.imshow('gray', gray)



    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
