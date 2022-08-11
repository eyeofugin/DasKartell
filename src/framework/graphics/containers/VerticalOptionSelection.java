package framework.graphics.containers;

import framework.eventhandling.Connector;
import framework.eventhandling.Event;
import framework.graphics.base.BaseGraphical;
import framework.graphics.text.MyColor;
import framework.graphics.text.TextAlignment;

public class VerticalOptionSelection extends BaseGraphical {

    private static int BASE_OPTION_HEIGHT = 40;
    private static int BASE_OPTION_WIDTH = 120;

    private int hmargin, vmargin;

    int[] sizes;
    String[] options;
    Event[] events;


    public VerticalOptionSelection(int x, int y, int xanchor, int yanchor, Connector connector) {
        super(x, y, xanchor, yanchor, connector);
        this.options = new String[0];
        this.events = new Event[0];
    }

    public void setSizes(int[] sizes) {
        this.sizes = sizes;
    }

    public void addEntry(String option, Event e) {
        String[] optionCopy = this.options.clone();
        Event[] eventCopy = this.events.clone();
        this.options = new String[1 + this.options.length];
        this.events = new Event[1 + this.events.length];
        for (int i = 0; i < optionCopy.length; i++) {
            this.options[i] = optionCopy[i];
            this.events[i] = eventCopy[i];
        }
        this.options[this.options.length - 1] = option;
        this.events[this.events.length - 1] = e;
    }

    public int[] build() {
//		background(MyColor.BLUE);
        calcMargins();
        buildOptions();

        return this.pixels;
    }

    private void buildOptions() {
        int yoff = vmargin;
        for (int i = 0; i < this.options.length; i++) {
            int xoff = calcxoff(i);
            int width = getWidth(i);
            if (this.events[i] != null) {
                writeButton(this.options[i], xoff, yoff, width, BASE_OPTION_HEIGHT, MyColor.BLACK, MyColor.WHITE);
                this.connector.addEventSize(this.events[i], xoff + xanchor, yoff + yanchor, width, BASE_OPTION_HEIGHT);
            } else {
                writeLineSize(this.options[i], xoff, yoff, width, BASE_OPTION_HEIGHT, 0, TextAlignment.CENTER, MyColor.BLACK, MyColor.WHITE);
            }
            yoff += (vmargin + BASE_OPTION_HEIGHT);
        }
    }

    private int getWidth(int i) {
        if (this.sizes == null) {
            return BASE_OPTION_WIDTH;
        }
        return this.sizes[i];
    }

    private int calcxoff(int i) {
        if (this.sizes == null) {
            return (this.width - BASE_OPTION_WIDTH) / 2;
        }
        return (this.width - this.sizes[i]) / 2;
    }

    private void calcMargins() {
        this.hmargin = (this.width - BASE_OPTION_WIDTH) / 2;
        this.vmargin = (this.height - BASE_OPTION_HEIGHT * this.options.length) / (this.options.length + 1);
    }
}