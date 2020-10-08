package objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintCanvas {
        private Graphics g;
        private Insets insets;
        private int width;
        private int height;
        private ArrayList<Figure> figures;

        public void addFigure(Figure figure){
            if(figures == null){
                figures = new ArrayList<>();
            }
            figure.setCanvas(this);
            figures.add(figure);
        }

        public List<Figure> getFigures(){
        return figures;
    }

         public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void setGraphics(Graphics g) {
            this.g = g;
        }

        public void setInsets(Insets insets) {
            this.insets = insets;
        }

        public void setColor(Color color)
        {
            g.setColor(color);
        }

        public void fillRect(int x, int y, int width, int height, Color color) {
            g.setColor(color);
            g.fillRect(x + insets.left, y + insets.top, width, height);
        }

        public void fillOval(int x, int y, int radius, Color color){
            g.setColor(color);
            g.fillOval(x + insets.left - radius , y + insets.top - radius, radius * 2, radius * 2);
        }

        public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color){
            g.setColor(color);

            g.fillPolygon(new int[] {x1 + insets.left, x2 + insets.left, x3 + insets.left},
                    new int[] {y1 + insets.top, y2 + insets.top, y3 + insets.top}, 3);

        }
    }
