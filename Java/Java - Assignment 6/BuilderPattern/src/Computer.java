public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final String graphicCard;
    private final boolean isBluetoothEnabled;
    private final boolean isWifiEnabled;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicCard = builder.graphicCard;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWifiEnabled = builder.isWifiEnabled;
    }

    public static Builder builder(String cpu, int ram, int storage) {
        return new Builder(cpu, ram, storage);
    }

    public static class Builder {
        private final String cpu;
        private final int ram;
        private final int storage;

        private String graphicCard = "Integrated";
        private boolean isBluetoothEnabled = false;
        private boolean isWifiEnabled = true;

        public Builder(String cpu, int ram, int storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder graphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public Builder bluetoothEnabled(boolean enabled) {
            this.isBluetoothEnabled = enabled;
            return this;
        }

        public Builder wifiEnabled(boolean enabled) {
            this.isWifiEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", graphicCard='" + graphicCard + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isWifiEnabled=" + isWifiEnabled +
                '}';
    }
}
