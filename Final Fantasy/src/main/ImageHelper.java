package main;

/**
 * @(#)ImageHelper.java
 *
 * From http://www.javalobby.org/articles/ultimate-image/#8
 */
 
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class ImageHelper {
 
     public static BufferedImage loadImage(String ref) 
     {   
         BufferedImage bimg = null;   
         try {   
   
             bimg = ImageIO.read(new File(ref));   
         } catch (Exception e) {   
             e.printStackTrace();   
         }   
         return bimg;   
     }  

  public static BufferedImage loadTranslucentImage(String ref, float transperancy) 
  {   
         // Load the image   
         BufferedImage loaded = loadImage(ref);   
         // Create the image using the    
         BufferedImage aimg = new BufferedImage(loaded.getWidth(), loaded.getHeight(), BufferedImage.TRANSLUCENT);   
         // Get the images graphics   
         Graphics2D g = aimg.createGraphics();   
         // Set the Graphics composite to Alpha   
         g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transperancy));   
         // Draw the LOADED img into the prepared reciver image   
         g.drawImage(loaded, null, 0, 0);   
         // let go of all system resources in this Graphics   
         g.dispose();   
         // Return the image   
         return aimg;   
     }  

     public static BufferedImage makeColorTransparent(BufferedImage ref, Color color) 
     {    
         BufferedImage dimg = new BufferedImage(ref.getWidth(), ref.getHeight(), BufferedImage.TYPE_INT_ARGB);
         Graphics2D g = dimg.createGraphics();   
      g.setComposite(AlphaComposite.Src);   
      g.drawImage(ref, null, 0, 0);   
      g.dispose();   
      for(int i = 0; i < dimg.getHeight(); i++) {   
          for(int j = 0; j < dimg.getWidth(); j++) {   
              if(dimg.getRGB(j, i) == color.getRGB()) {   
              dimg.setRGB(j, i, 0x8F1C1C);   
              }   
          }   
      }   
      return dimg;   
  }  
  
     public static BufferedImage horizontalflip(BufferedImage img) 
     {   
         int w = img.getWidth();   
         int h = img.getHeight();   
         BufferedImage dimg = new BufferedImage(w, h, img.getType());   
         Graphics2D g = dimg.createGraphics();   
         g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);   
         g.dispose();   
         return dimg;   
     }  
      
     public static BufferedImage verticalflip(BufferedImage img) 
     {   
         int w = img.getWidth();   
         int h = img.getHeight();   
         BufferedImage dimg = new BufferedImage(w, h, img.getColorModel().getTransparency());   
         Graphics2D g = dimg.createGraphics();   
         g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);   
         g.dispose();   
         return dimg;   
     }   

  public static BufferedImage rotate(BufferedImage img, int angle) 
  {   
         int w = img.getWidth();   
         int h = img.getHeight();   
         BufferedImage dimg = new BufferedImage(w, h, img.getType());   
         Graphics2D g = dimg.createGraphics();   
         g.rotate(Math.toRadians(angle), w/2, h/2);   
         g.drawImage(img, null, 0, 0);   
         return dimg;   
     }  
      
  public static BufferedImage resize(BufferedImage img, int newW, int newH) 
  {   
         int w = img.getWidth();   
         int h = img.getHeight();   
         BufferedImage dimg = new BufferedImage(newW, newH, img.getType());   
         Graphics2D g = dimg.createGraphics();   
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);   
         g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);   
         g.dispose();   
         return dimg;   
     }  
      
     public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) 
     {   
         int w = img.getWidth()/cols;   
         int h = img.getHeight()/rows;      
         BufferedImage imgs[] = new BufferedImage[w*h];   
         for(int y = 0; y < rows; y++) {   
             for(int x = 0; x < cols; x++) {   
               imgs[x*rows+y]=img.getSubimage(x*w,y*h,w,h);
             }   
         }   
         return imgs;   
     }  




}