package ThuatToanBaoMatRSA;

import java.math.BigInteger;
import java.util.Random;

public class RSA_Dao {
	public static final int soBit = 1024;
    public static final BigInteger soE = BigInteger.valueOf(65537);

    private BigInteger soP;
    private BigInteger soQ;
    private BigInteger soN;
    private BigInteger soPhiN;
    private BigInteger soD;

    public void khoiTao() {
        soP = taoSoNguyenTo();
        soQ = taoSoNguyenTo();
        soN = soP.multiply(soQ);
        soPhiN = (soP.subtract(BigInteger.ONE)).multiply(soQ.subtract(BigInteger.ONE));
        soD = nghichDaoModulo(soE, soPhiN);
    }

    public BigInteger getSoN() {
		return soN;
	}

	public void setSoN(BigInteger soN) {
		this.soN = soN;
	}

	public BigInteger getSoD() {
		return soD;
	}

	public void setSoD(BigInteger soD) {
		this.soD = soD;
	}

	public BigInteger taoKhoaCongKhaiN() {
        return soN = soP.multiply(soQ);
    }

    public BigInteger taoKhoaBiMat() {
        soD = nghichDaoModulo(soE, soPhiN);
        return soD;
    }

    public String maHoa(String thongDiep, BigInteger soN) {
        BigInteger thongDiepSo = new BigInteger(thongDiep.getBytes());
        return luyThuaModulo(thongDiepSo, soE, soN).toString();
    }

    public String giaiMa(BigInteger thongDiepDaMa, BigInteger khoa) {
        BigInteger giaiMaSo = luyThuaModulo(thongDiepDaMa, khoa, soN);
        return new String(giaiMaSo.toByteArray());
    }

    private BigInteger taoSoNgauNhien() {
        BigInteger gioiHanTren = BigInteger.ONE.shiftLeft(soBit);
        BigInteger soNgauNhien;
        Random boSinhNgauNhien = new Random();
        do {
            soNgauNhien = new BigInteger(gioiHanTren.bitLength(), boSinhNgauNhien);
        } while (soNgauNhien.compareTo(gioiHanTren) >= 0);
        return soNgauNhien;
    }

    private BigInteger taoSoNguyenTo() {
        BigInteger so;
        do {
            so = taoSoNgauNhien();
        } while (!kiemTraSoNguyenTo(so));
        return so;
    }

    
    //thuật toán Miller-Rabin
    private boolean kiemTraSoNguyenTo(BigInteger so) {
        int lanKiemTra = 5;
        if (so.equals(BigInteger.ONE) || so.equals(BigInteger.valueOf(2))) {
            return true;
        }
        if (so.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            return false;
        }
        BigInteger d = so.subtract(BigInteger.ONE);
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.valueOf(2));
        }
        for (int i = 0; i < lanKiemTra; i++) {
            BigInteger a = BigInteger.valueOf(Math.abs(new Random().nextInt())).mod(so.subtract(BigInteger.ONE)).add(BigInteger.ONE);
            BigInteger temp = d;
            BigInteger x = a.modPow(temp, so);
            while (!temp.equals(so.subtract(BigInteger.ONE)) && !x.equals(BigInteger.ONE) && !x.equals(so.subtract(BigInteger.ONE))) {
                x = x.multiply(x).mod(so);
                temp = temp.multiply(BigInteger.valueOf(2));
            }
            if (!x.equals(so.subtract(BigInteger.ONE)) && temp.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }



    //sử dụng thuật toán “Square and Multiply”
    private BigInteger luyThuaModulo(BigInteger coSo, BigInteger soMu, BigInteger soModulo) {
        BigInteger ketQua = BigInteger.ONE;
        while (soMu.compareTo(BigInteger.ZERO) > 0) {
            if (soMu.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                ketQua = (ketQua.multiply(coSo)).mod(soModulo);
            }
            coSo = (coSo.multiply(coSo)).mod(soModulo);
			soMu = soMu.divide(new BigInteger("2"));
        }
        return ketQua;
    }
    

    //sử dụng thuật toán Euclid mở rộng
    public static BigInteger nghichDaoModulo(BigInteger a, BigInteger m) {
        BigInteger m0 = m;
        BigInteger t, q;
        BigInteger x0 = BigInteger.ZERO, x1 = BigInteger.ONE;
        BigInteger y0 = BigInteger.ONE, y1 = BigInteger.ZERO;

        if (m.equals(BigInteger.ONE))
            return BigInteger.ZERO;

        while (a.compareTo(BigInteger.ONE) > 0) {
            q = a.divide(m);
            t = m;

            m = a.mod(m);
            a = t;

            t = x0;
            x0 = x1.subtract(q.multiply(x0));
            x1 = t;

            t = y0;
            y0 = y1.subtract(q.multiply(y0));
            y1 = t;
        }

        if (x1.compareTo(BigInteger.ZERO) < 0)
            x1 = x1.add(m0);

        return x1;
    }


}
