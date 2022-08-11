package framework.graphics.containers;

import framework.eventhandling.Connector;
import framework.graphics.base.BaseGraphical;
import game.objects.units.Entity;

import java.awt.*;

public class Board extends BaseGraphical {

    private static final int ROWS_PER_TEAM = 2;
    private static final int TEAMS = 2;
    private static final int CHARS_PER_ROW = 4;
    private static final int WIDTH = 780;
    private static final int HEIGHT = 970;
    private static final int CHAR_VIEW_PADDING = 20;
    private static final int TEAM_PADDING = 190;

    private Entity[][] entities;

    public Board(Entity[][] entities, int xanchor, int yanchor, Connector connector) {
        super(WIDTH,HEIGHT,xanchor,yanchor,connector);
        this.entities = entities;
    }
    public int[] build() {
        buildChars();
        return this.pixels;
    }
    private void buildChars() {
        for (int row = 0; row < entities.length; row++) {
            for (int c = 0; c < entities[row].length; c++) {
                Point fieldAnchor = calculateCharFieldAnchor(row,c);
                CharacterFieldView cfv = new CharacterFieldView(entities[row][c],
                        fieldAnchor.x + xanchor, fieldAnchor.y + yanchor,connector);
                int[] cfvPixels = cfv.build();
                int cfvindex = 0;
                for(int i = fieldAnchor.x; i < fieldAnchor.x + CharacterFieldView.NORMAL_WIDTH; i++) {
                    for(int j = fieldAnchor.y; j < fieldAnchor.y + CharacterFieldView.NORMAL_HEIGHT; j++) {
                        this.pixels[j+i*WIDTH] = cfvPixels[cfvindex];
                        cfvindex++;
                    }
                }
            }
        }
    }

    private Point calculateCharFieldAnchor(int row, int character) {
        int horizontalStep = CharacterFieldView.NORMAL_WIDTH + CHAR_VIEW_PADDING;
        int verticalStep = CharacterFieldView.NORMAL_HEIGHT + CHAR_VIEW_PADDING;
        int x = character * horizontalStep;
        int y = row < 2 ? row * verticalStep : row * verticalStep + TEAM_PADDING;
        return new Point(x,y);
    }
}
