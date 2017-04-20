/**
 * Created by dominikzaq on 24.12.2016.
 */
abstract class RemoteControl {
    public abstract void pressSwitch(TV context);
}

class Off extends  RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am off");
        context.setState(new On());
    }
}

class On extends  RemoteControl {

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am on");
        context.setState(new Off());
    }
}

class TV {
    private RemoteControl state;

    public RemoteControl getState() {
        return state;
    }

    public void setState(RemoteControl state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressSwitch(this);
    }

    public TV(RemoteControl state) {
        this.state = state;
    }
}

class StatePatternEx {
    public static void main(String[] args) throws InterruptedException {
        Off initialState = new Off();
        TV tv = new TV(initialState);
        for(int i = 0; i < 15; i++) {
            Thread.sleep(1000);
            tv.pressButton();
        }
    }
}