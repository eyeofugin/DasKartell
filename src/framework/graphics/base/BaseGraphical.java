package framework.graphics.base;

import framework.eventhandling.Connector;
import framework.graphics.text.MyColor;
import framework.graphics.text.TextAlignment;
import framework.graphics.text.TextEditor;
import framework.loading.Property;

public class BaseGraphical {
    //general
    protected int width;
    protected int height;

    protected int xanchor, yanchor;

    protected int[] pixels;

    protected Connector connector;
    protected TextEditor editor;


    public BaseGraphical() {
    }
    public BaseGraphical(int width, int height, int xanchor, int yanchor, Connector connector) {
        this.pixels=new int[width*height];
        this.width=width;
        this.height=height;
        this.xanchor=xanchor;
        this.yanchor=yanchor;
        this.editor = new TextEditor(TextEditor.baseConf);
        this.connector = connector;
    }
    public BaseGraphical(int width, int height, TextEditor.TextEditorConfig conf, int xanchor, int yanchor, Connector connector) {
        this.pixels=new int[width*height];
        this.width=width;
        this.height=height;
        this.xanchor=xanchor;
        this.yanchor=yanchor;
        this.editor = new TextEditor(conf);
        this.connector = connector;
    }

    protected void writeLineFromTo(String text, int xFrom, int xUntil, int yFrom, int yUntil, int fontSize, TextAlignment alignment, MyColor backGround, MyColor font) {

        int[] result = editor.getTextLine(text, (xUntil-xFrom+1),(yUntil-yFrom+1),fontSize,alignment,backGround, font);
//		print(result,(xUntil-xFrom+1),(yUntil-yFrom+1));
        int index = 0;
        for(int y = yFrom; y <= yUntil; y++) {
            for(int x = xFrom; x <= xUntil; x++) {
                if(result[index]!=-12450784) {
                    pixels[x + y * this.width] = result[index];
                }else if(!backGround.equals(MyColor.VOID)) {
                    pixels[x + y * this.width] = backGround.VALUE;
                }
                index++;
            }
        }
    }
    protected void writeLineSize(String text, int xfrom, int yfrom, int width, int height, int fontSize, TextAlignment alignment, MyColor backGround, MyColor font) {
        int[] result = editor.getTextLine(text, width,height,fontSize,alignment,backGround, font);
//		print(result,width,height);
        int xuntil = xfrom+width-1;
        int yuntil = yfrom+height-1;
        int index = 0;
        for(int y = yfrom; y <= yuntil; y++) {
            for(int x = xfrom; x <= xuntil; x++) {
                if(result[index]!=-12450784) {
                    pixels[x + y * this.width] = result[index];
                }else if(!backGround.equals(MyColor.VOID)) {
                    pixels[x + y * this.width] = backGround.VALUE;
                }
                index++;
            }
        }
    }
    public void writeButton(String label,int xfrom, int yfrom, MyColor backGroundColor, MyColor fontColor) {
        writeButton(label, xfrom, yfrom, Property.BUTTON_NORMAL_WIDTH, Property.BUTTON_NORMAL_HEIGHT, backGroundColor, fontColor);
    }
    public void writeButton(String label,int xfrom, int yfrom, int width, int height, MyColor backGroundColor, MyColor fontColor) {
        int[] result = editor.getButtonLine(label,width,height,backGroundColor,fontColor);
//		print(result,width,height);
        int xuntil = xfrom+width-1;
        int yuntil = yfrom+height-1;
        int index = 0;
        for(int y = yfrom; y <= yuntil; y++) {
            for(int x = xfrom; x <= xuntil; x++) {
                if(result[index]!=-12450784) {
                    pixels[x + y * this.width] = result[index];
                }else if(!backGroundColor.equals(MyColor.VOID)) {
                    pixels[x + y * this.width] = backGroundColor.VALUE;
                }
                index++;
            }
        }
    }
    protected void fillWithGraphics(int xfrom, int xuntil, int yfrom, int yuntil, int[] graphics, boolean bordered) {
        fillWithGraphics(xfrom,xuntil,yfrom,yuntil,graphics,bordered,MyColor.BLACK);
    }
    protected void fillWithGraphics(int xfrom, int xuntil, int yfrom, int yuntil, int[] graphics, boolean bordered, MyColor backgroundColor) {

        if(bordered) {
            for (int i = xfrom - 1; i < xuntil + 2; i++) {
                pixels[i + (yfrom - 1) * this.width] = -1;
                pixels[i + (yuntil + 1) * this.width] = -1;
            }
            for (int i = yfrom - 1; i < yuntil + 2; i++) {
                pixels[(xfrom - 1) + i * this.width] = -1;
                pixels[(xuntil + 1) + i * this.width] = -1;
            }
        }

        int index = 0;
        for(int i = yfrom; i <=yuntil; i++) {
            for(int j = xfrom; j <= xuntil; j++) {

                if(graphics[index]!=MyColor.VOID.VALUE) {
                    pixels[j + i * this.width] = graphics[index];
                }else if(!backgroundColor.equals(MyColor.VOID)) {
                    pixels[j + i * this.width] = backgroundColor.VALUE;
                }
                index++;
            }
        }
    }
    protected void writeBar(int xFrom, int xUntil, int yFrom, int yUntil, double percentage, MyColor color) {

        int filledSize = (int)((xUntil+1-xFrom) * percentage);

        for(int x = xFrom; x <= (xFrom+filledSize); x++) {
            for(int y = yFrom; y <= yUntil; y++) {
                pixels[x+y*width] = color.VALUE;
            }
        }

        for (int i = xFrom - 1; i < xUntil + 2; i++) {
            pixels[i + (yFrom - 1) * this.width] = -1;
            pixels[i + (yUntil + 1) * this.width] = -1;
        }
        for (int i = yFrom - 1; i < yUntil + 2; i++) {
            pixels[(xFrom - 1) + i * this.width] = -1;
            pixels[(xUntil + 1) + i * this.width] = -1;
        }
    }
    public void background(MyColor color) {
        for(int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = color.VALUE;
        }
    }
    public void border(MyColor color) {
        int c = color!=null?color.VALUE:MyColor.WHITE.VALUE;
        for(int i = 0; i < this.width; i++) {
            this.pixels[i]=c;
            this.pixels[i+(this.height-1)*this.width]=c;
        }
        for(int i = 0; i < this.height; i++) {
            this.pixels[i*this.width]=c;
            this.pixels[this.width-1+i*this.width]=c;
        }
    }
    protected void print(int[] p, int width, int height) {
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                int i = p[y+x*width];
                if(i == 0) {
                    System.out.print(". ");
                }else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
    protected void clear() {
        this.pixels = new int[this.pixels.length];
    }
    public int[] getPixels() {
        return this.pixels;
    }

}
