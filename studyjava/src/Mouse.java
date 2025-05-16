public class Mouse {
    private int pointX;
    private int pointY;

    public void moveMouse(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }

    public void leftClick() {
        System.out.println("마우스(" + pointX + ", " + pointY + ") 왼쪽버튼 클릭됨");
    }

    public void rightClick() {
        System.out.println("마우스(" + pointX + ", " + pointY + ") 오른쪽버튼 클릭됨");
    }
}
