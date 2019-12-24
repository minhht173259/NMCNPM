package com.rest.utils.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author NMCNPM
 */
@XmlRootElement
public class CartObject {

	private final List<ProductObject> Giohang;

	public CartObject() {
		Giohang = new ArrayList<ProductObject>();
	}

	public void addSanpham(ProductObject p) {
		boolean contain = false;

		for (int i = 0; i < Giohang.size(); i++) {
			if (p.getId() == Giohang.get(i).getId()) {
				Giohang.get(i).setAmount(Giohang.get(i).getAmount() + p.getAmount());
				contain = true;
			}
		}

		if (!contain)
			Giohang.add(p);
	}

	public void updateSanpham(int id, int amount) {
		for (int i = 0; i < Giohang.size(); i++) {
			if (id == Giohang.get(i).getId()) {
				Giohang.get(i).setAmount(amount);
				return;
			}
		}
	}

	public void delSanpham(int id) {
		for (int i = 0; i < Giohang.size(); i++) {
			if (id == Giohang.get(i).getId()) {
				Giohang.remove(i);
				return;
			}
		}
	}

	public long getTotalprice() {
		long totalprice = 0;
		for (ProductObject p : Giohang) {
			totalprice += p.getAmount() * p.getPrice();
		}
		return totalprice;
	}

	public List<ProductObject> getGiohang() {
		return Giohang;
	}
}
