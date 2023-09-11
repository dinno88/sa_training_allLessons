public class School{
	
	/*Fields*/
	private String name;
	private String address;

	/*Cunstructor*/
	public School(){
		System.out.printf("School Constructor invoke... %n");
	}
		/*Method Setter*/
		public void setName(String name){
			this.name = name;
		}
		/*Method Getter*/
		public String getName(){
			return this.name;
		}
		/*Method Setter*/
		public void setAddress(String address){
			this.address = address;
		}
		/*Method Getter*/
		public String getAddress(){
			return this.address;
		}
}