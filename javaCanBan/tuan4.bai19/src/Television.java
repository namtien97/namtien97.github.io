public class Television {
    private int channel;
    private int volume;

    public Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }


    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int nextChannel() {
        return getChannel() + 1;
    }

    public int beforeChannel() {
        return getChannel() + 1;
    }

    public int upVolume() {
        return getVolume() + 1;
    }

    public int downVolume() {
        return downVolume() + 1;
    }

    public String onTelevision() {
        return "bat";
    }

    public String offTelevision() {
        return "tat";
    }
}
