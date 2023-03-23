public class Vehicle {

    public int[] getFallback1() {
        return fallback1;
    }

    public void setFallback1(int[] fallback1) {
        this.fallback1 = fallback1;
    }

    public String[] getMod1Ctrls() {
        return mod1Ctrls;
    }

    public void setMod1Ctrls(String[] mod1Ctrls) {
        this.mod1Ctrls = mod1Ctrls;
    }

    public String[] getMod2Ctrls() {
        return mod2Ctrls;
    }

    public void setMod2Ctrls(String[] mod2Ctrls) {
        this.mod2Ctrls = mod2Ctrls;
    }

    public String[] getMod3Ctrls() {
        return mod3Ctrls;
    }

    public void setMod3Ctrls(String[] mod3Ctrls) {
        this.mod3Ctrls = mod3Ctrls;
    }

    String[] mod1Ctrls;
    String[] mod2Ctrls;
    String[] mod3Ctrls;
    int[] fallback1;
   int[] fallback2;
    int[] fallback3;
    int abs;
    int sc;
    int ca;
    int erpm;
    double tl;
    int ei;
    int msad;
    int cpa;
    boolean ecu1State;
    public boolean getEcuState(int ecu){
        boolean state;
        switch(ecu) {
            case 1:
               state = isEcu1State();
                break;
            case 2:
                state = isEcu2State();
                break;

            default:
                state = isEcu3State();
        }
        return state;
    }
    public boolean isEcu1State() {
        return ecu1State;
    }

    public void setEcu1State(boolean ecu1State) {
        this.ecu1State = ecu1State;
    }

    public boolean isEcu2State() {
        return ecu2State;
    }

    public void setEcu2State(boolean ecu2State) {
        this.ecu2State = ecu2State;
    }

    public boolean isEcu3State() {
        return ecu3State;
    }

    public void setEcu3State(boolean ecu3State) {
        this.ecu3State = ecu3State;
    }

    boolean ecu2State;
    boolean ecu3State;


    public int[] getFallback2() {
        return fallback2;
    }

    public void setFallback2(int[] fallback2) {
        this.fallback2 = fallback2;
    }

    public int[] getFallback3() {
        return fallback3;
    }

    public void setFallback3(int[] fallback3) {
        this.fallback3 = fallback3;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getErpm() {
        return erpm;
    }

    public void setErpm(int erpm) {
        this.erpm = erpm;
    }

    public double getTl() {
        return tl;
    }

    public void setTl(double tl) {
        this.tl = tl;
    }

    public int getEi() {
        return ei;
    }

    public void setEi(int ei) {
        this.ei = ei;
    }

    public int getMsad() {
        return msad;
    }

    public void setMsad(int msad) {
        this.msad = msad;
    }

    public int getCpa() {
        return cpa;
    }

    public void setCpa(int cpa) {
        this.cpa = cpa;
    }

    public int getGps() {
        return gps;
    }

    public void setGps(int gps) {
        this.gps = gps;
    }

    public int getTcs() {
        return tcs;
    }

    public void setTcs(int tcs) {
        this.tcs = tcs;
    }

    int gps;
    int tcs;

    public double getIcvf() {
        return icvf;
    }

    public void setIcvf(double icvf) {
        this.icvf = icvf;
    }

    double icvf;

    public Vehicle(boolean ecu1State, boolean ecu2State, boolean ecu3State, int[] fallback1, int[] fallback2, int[] fallback3, int abs, int sc, int ca, int erpm, double tl, int ei, double icvf, int msad, int cpa, int tcs, int gps){
        setEcu1State(ecu1State);
        setEcu2State(ecu2State);
        setEcu3State(ecu3State);
        setFallback1(fallback1);
        setFallback2(fallback2);
        setFallback3(fallback3);
        setAbs(abs);
        setSc(sc);
        setCa(ca);
        setErpm(erpm);
        setTl(tl);
        setEi(ei);
        setMsad(msad);
        setCpa(cpa);
        setIcvf(icvf);
        setTcs(tcs);
        setGps(gps);
    }
}
