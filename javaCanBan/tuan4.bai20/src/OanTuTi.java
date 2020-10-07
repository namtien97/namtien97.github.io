public class OanTuTi {
    private String userChoose;
    private String machineChoose;

    public OanTuTi(String userChoose,String machineChoose){
        this.userChoose = userChoose;
        this.machineChoose = machineChoose;
    }

    public String getUserChoose() {
        return userChoose;
    }

    public String getMachineChoose() {
        return machineChoose;
    }

    public String logic(){
        if(getMachineChoose().equals(getUserChoose())){
            return "hoa";
        }else if(getMachineChoose().equals("Keo") && getUserChoose().equals("La")){
            return "thua";
        }else if(getMachineChoose().equals("La") && getUserChoose().equals("Keo")){
            return "thang";
        }else if(getMachineChoose().equals("Bua") && getUserChoose().equals("Keo")){
            return "thua";
        }else if (getMachineChoose().equals("Keo") && getUserChoose().equals("Bua")){
            return "thang";
        }else if (getMachineChoose().equals("La") && getUserChoose().equals("Bua")) {
            return "thua";
        }else{
            return "thang";
        }
    }
}
