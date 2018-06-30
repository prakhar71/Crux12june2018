package crux12june2018;

public class DynamicStack extends Stack {

	
	@Override
	public void push(int item) throws Exception {
		
		if(this.size() == this.data.length) {
			int [] os=this.data;
			int [] ns = new int[os.length *2];
			
			for(int i=0;i<os.length;i++) {
				ns[i]=os[i];
			}
			
			
			this.data=ns;
		}
		super.push(item);
	}
}
