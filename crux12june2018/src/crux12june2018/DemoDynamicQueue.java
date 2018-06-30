package crux12june2018;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class DemoDynamicQueue extends Queue {

	public DemoDynamicQueue(int cap) {
		super(cap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enque(int item) throws Exception {
		
		if(this.size == this.data.length) {
			
			int oq[] = this.data;
			int nq[]= new int[oq.length *2];
			
			for(int i=0;i<oq.length;i++) {
				int idx= (this.front + i)% data.length;
				nq[i]=data[idx];
			}
			
			this.data=nq;
		}
		
		super.enque(item);
	}

}
