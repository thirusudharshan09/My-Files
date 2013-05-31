 import javax.media.jai.*;
 import javax.media.jai.widget.*;

import com.sun.media.jai.codec.FileSeekableStream;

import java.awt.Frame;
import java.awt.image.renderable.ParameterBlock;
import java.io.IOException;

 public class AddExample extends Frame {

      // ScrollingImagePanel is a utility widget that
      // contains a Graphics2D (i.e., is an image sink).
      static ScrollingImagePanel imagePanel1;

      // For simplicity, we just do all the work in the
      // class constructor.
      public AddExample(ParameterBlock param1,
                        ParameterBlock param2) {

           // Create a constant image
           RenderedOp im0 = JAI.create("constant", param1);

           // Create another constant image.
           RenderedOp im1 = JAI.create("constant", param2);
           // Add the two images together.

           RenderedOp im2 = JAI.create("add", im0, im1);

           // Display the original in a scrolling window
           imagePanel1 = new ScrollingImagePanel(im2, 100, 100);

           // Add the display widget to our frame.
           add(imagePanel1);
      }
      public static void main(String args[])
      {
      FileSeekableStream fi = null;
      try
      {
      fi = new FileSeekableStream("MRI_scanner-SPL.jpg");
      }
      catch(IOException ex)
      {
      System.out.println("Error opening the image");
      System.exit(0);
      }
      RenderedOp image1 = JAI.create("stream",fi);
   
      ParameterBlock params=new ParameterBlock();
      params.addSource(image1); // first specify the image
    
      ParameterBlock params1=new ParameterBlock();
      params1.addSource(image1); // first specify the image
     
      AddExample ad=new AddExample(params, params1);
      
      Frame window=new Frame("JAI Sample Program");
      window.add(imagePanel1);
      window.pack();
      window.show();

      }
 }

