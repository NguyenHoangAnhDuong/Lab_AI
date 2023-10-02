package lab1_Task1;

import lab1_Task1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState().equals(LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_B)) {
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
		
	}
}