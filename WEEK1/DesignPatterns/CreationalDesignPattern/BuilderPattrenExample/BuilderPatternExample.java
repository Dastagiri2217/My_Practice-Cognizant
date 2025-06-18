class Computer {
	private String CPU;
	private int RAM;
	private int Storage;
	private String graphicCard;
	
	public Computer(Builder builder) {
		this.CPU = builder.CPU;
		this.RAM = builder.RAM;
		this.Storage = builder.Storage;
		this.graphicCard = builder.graphicCard;
	}
	public String getCPU() {
		return CPU;
	}
	public int getRAM() {
		return RAM;
	}
	public int getStorage() {
		return Storage;
	}
	public String getGraphicCard() {
		return graphicCard;
	}
	
	@Override
	public String toString() {
		return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + ", graphicCard=" + graphicCard + "]";
	}

static class Builder{ //here static is imp becz we are going to acces its methods when ever we need
		private String CPU;
		private int RAM;
		private int Storage;
		private String graphicCard;
		public Builder setCPU(String CPU) {
			this.CPU =CPU;
			return this;
		}
		public Builder setRam(int ram) {
			this.RAM = ram;
			return this;
		}
		public Builder setStorage(int storage) {
			this.Storage = storage;
			return this;
		}
		public Builder setGraphicCard(String gcard) {
			this.graphicCard = gcard;
			return this;
		}
		public Computer build() {
			return new Computer(this);
		}
	}
}
public class BuilderPatternExample{
	public static void main(String args[]) {
		Computer pc = new Computer.Builder().setCPU("Intel i5").setRam(8).setStorage(512).build();
		System.out.println(pc);
		System.out.println();
		Computer gamingpc = 
		new Computer.Builder().setCPU("Ryzon").setRam(12).setStorage(1024).setGraphicCard("sony 12bg").build();
		System.out.println(gamingpc);
		System.out.println();
		Computer schoolpc =
		new Computer.Builder().setCPU("intel i3").setRam(4).setStorage(256).build();
		System.out.println(schoolpc);
		
	}
}
//by this Builder Design Pattern we can invoke multiple methods on single object and 
//also no need to remember the order of params if we have may
