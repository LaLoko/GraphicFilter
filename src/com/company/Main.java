package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Ramka extends JFrame{
    private final BufferedImage first_image = ImageIO.read(new File("first.jpg"));
    private final BufferedImage second_image = ImageIO.read(new File("second.jpg"));
    private final int height = first_image.getHeight();
    private final int wight = first_image.getWidth();
    private int red;
    private int green;
    private int blue;
    private Color c1;
    private Color c2;
    private Color oc;
    private final BufferedImage output_image = ImageIO.read(new File("output.jpg"));
    private final JLabel label = new JLabel();

    Ramka() throws IOException {
        add(new Main_panel());

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class Main_panel extends JPanel{
        Main_panel(){
            setLayout(new GridLayout(1,2));
            setBackground(Color.black);
            add(new Photo_panel());
            add(new Button_panel());
            setVisible(true);
        }
    }
    class Photo_panel extends JPanel{
        Photo_panel(){
            setBackground(Color.black);
            add(label);
            setVisible(true);
        }
    }
    class Button_panel extends JPanel{
        Button_panel(){
            setBackground(Color.black);
            setLayout(new GridLayout(8,2));
            JButton additive  = new JButton("Additive");
            JButton subtractive  = new JButton("Subtractive");
            JButton difference  = new JButton("Difference");
            JButton multiply = new JButton("Multiply");
            JButton screen  = new JButton("Screen");
            JButton negation  = new JButton("Negation");
            JButton darken = new JButton("Darken");
            JButton lighten  = new JButton("Lighten");
            JButton exclusion  = new JButton("Exclusion");
            JButton overlay  = new JButton("Overlay");
            JButton hard_light  = new JButton("Hard light");
            JButton soft_light  = new JButton("Soft light");
            JButton color_dodge = new JButton("Color dodge");
            JButton color_burn = new JButton("Color burn");
            JButton reflect = new JButton("Reflect");


            additive.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = sum_check(c1.getRed(),c2.getRed());
                        green = sum_check(c1.getRed(),c2.getRed());
                        blue = sum_check(c1.getRed(),c2.getRed());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());

                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            subtractive.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = sub_check(c1.getRed(),c2.getRed());
                        green = sub_check(c1.getRed(),c2.getRed());
                        blue = sub_check(c1.getRed(),c2.getRed());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());

                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            difference.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = Math.abs(c1.getRed()-c2.getRed());
                        green = Math.abs(c1.getGreen()-c2.getGreen());
                        blue = Math.abs(c1.getBlue()-c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            multiply.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = mul_check(c1.getRed(),c2.getRed());
                        green = mul_check(c1.getGreen(),c2.getGreen());
                        blue = mul_check(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            screen.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = sc(c1.getRed(),c2.getRed());
                        green = sc(c1.getRed(),c2.getRed());
                        blue = sc(c1.getRed(),c2.getRed());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());

                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            negation.addActionListener(e -> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = 255 - Math.abs(255 - c1.getRed()-c2.getRed());
                        green = 255 - Math.abs(255 - c1.getGreen()-c2.getGreen());
                        blue = 255 - Math.abs(255 - c1.getBlue()-c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            darken.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = dark(c1.getRed(),c2.getRed());
                        green = dark(c1.getGreen(),c2.getGreen());
                        blue = dark(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            lighten.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = lig(c1.getRed(),c2.getRed());
                        green = lig(c1.getGreen(),c2.getGreen());
                        blue = lig(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            exclusion.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = exc(c1.getRed(),c2.getRed());
                        green = exc(c1.getGreen(),c2.getGreen());
                        blue = exc(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            overlay.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = ov(c1.getRed(),c2.getRed());
                        green = ov(c1.getGreen(),c2.getGreen());
                        blue = ov(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            hard_light.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = hd(c1.getRed(),c2.getRed());
                        green = hd(c1.getGreen(),c2.getGreen());
                        blue = hd(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            soft_light.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = sl(c1.getRed(),c2.getRed());
                        green = sl(c1.getGreen(),c2.getGreen());
                        blue = sl(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            color_dodge.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = cd(c1.getRed(),c2.getRed());
                        green = cd(c1.getGreen(),c2.getGreen());
                        blue = cd(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            color_burn.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = cb(c1.getRed(),c2.getRed());
                        green = cb(c1.getGreen(),c2.getGreen());
                        blue = cb(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });
            reflect.addActionListener(e-> {
                for (int x = 0; x < wight; x++) {
                    for (int y = 0; y < height; y++) {
                        c1 = new Color(first_image.getRGB(x,y));
                        c2 = new Color(second_image.getRGB(x,y));
                        red = rf(c1.getRed(),c2.getRed());
                        green = rf(c1.getGreen(),c2.getGreen());
                        blue = rf(c1.getBlue(),c2.getBlue());
                        oc = new Color(red,green,blue);
                        output_image.setRGB(x,y,oc.getRGB());
                    }
                }
                label.setIcon(new ImageIcon(output_image));
                label.repaint();
            });

            add(additive);
            add(subtractive);
            add(difference);
            add(multiply);
            add(screen);
            add(negation);
            add(darken);
            add(lighten);
            add(exclusion);
            add(overlay);
            add(hard_light);
            add(soft_light);
            add(color_dodge);
            add(color_burn);
            add(reflect);
            add(new trans());

            setVisible(true);
        }
        private int sum_check(int a,int b){
            return Math.min(a + b, 255);
        }
        private  int sub_check(int a,int b){
            return Math.max(((a + b) - 255), 0);
        }
        private int mul_check(int a,int b){
            if(a * b > 255) return a*b/255;
            else return a*b;
        }
        private int sc(int a,int b){
            int i = (255 - ((255-a)*(255-b)));
            return Math.max(i, 0);
        }
        private int dark(int a,int b){
            return Math.min(a, b);
        }
        private int lig(int a,int b){
            return Math.max(a, b);
        }
        private int exc(int a,int b){
            final int i = a + b - (2 * a * b)/255;
            return Math.max(i, 0);
        }
        private int ov(int a,int b){
            if(a <= 255/2)
                return Math.min(2 * a * b, 255);
            else
                return Math.max((255 - (2 * (255 - a) * (255 - b))), 0);
        }
        private int hd(int a,int b){
            if(b <= 255/2)
                return Math.min(2 * a * b, 255);
            else
                return Math.max((255 - (2 * (255 - a) * (255 - b))), 0);
        }
        private int sl(int a,int b){
            if(b <= 255/2) {
                final int i = (2 * b - 255) * (a - a * a);
                if ((i + a)<=0)return 0;
                else return Math.min((i + a), 255);
            }
            else {
                final int j = (int) ((2 * b - 255) * (Math.sqrt(a) - a) + a);
                if (j <= 0) return 0;
                else return Math.min(j, 255);
            }
        }
        private int cd(int a,int b){
            int i = (255-b);
            if(i > 0) return a/i;
            else if (i == 0) return 0;
            else return 0;
        }
        private int cb(int a,int b){
            int i = 255 - (255 - a);
            if( b != 0) return i/b;
            else return 255;
        }
        private int rf(int a,int b){
            if (b != 255)
                return Math.min(a * a / (255 - b), 255);
            else return 0;
        }

        class trans extends JPanel{
            trans(){
                setLayout(new GridLayout(1,2));
                JButton transparency = new JButton("Transparency");
                JSlider slider = new JSlider();
                slider.setValue(0);
                slider.setMinimum(0);
                slider.setMaximum(255);
                transparency.addActionListener(e-> {
                    for (int x = 0; x < wight; x++) {
                        for (int y = 0; y < height; y++) {
                            c1 = new Color(first_image.getRGB(x,y));
                            c2 = new Color(second_image.getRGB(x,y));
                            red = tr(c1.getRed(),c2.getRed(),slider.getValue());
                            green = tr(c1.getGreen(),c2.getGreen(),slider.getValue());
                            blue = tr(c1.getBlue(),c2.getBlue(),slider.getValue());
                            oc = new Color(red,green,blue);
                            output_image.setRGB(x,y,oc.getRGB());
                        }
                    }
                    label.setIcon(new ImageIcon(output_image));
                    label.repaint();
                });
                add(transparency);
                add(slider);
            }
            private int tr(int a,int b,int c){
                int i = (255 - c) * b + c *a;
                if(c == 255) return a;
                else return i/255;
            }
        }
    }
}


public class Main {

    public static void main(String[] args) {
        try {
            new Ramka();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
