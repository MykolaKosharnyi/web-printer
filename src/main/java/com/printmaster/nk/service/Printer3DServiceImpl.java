package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.Printer3dDAO;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

@Service
public class Printer3DServiceImpl implements Printer3DService {
     
    private Printer3dDAO printer3dDAO;
 
    public void setPrinter3dDAO(Printer3dDAO printer3dDAO) {
        this.printer3dDAO = printer3dDAO;
    }
 
    @Override
    @Transactional
    public int addPrinter(Printer3D p) {
        return this.printer3dDAO.addPrinter(p);
    }
 
    @Override
    @Transactional
    public void updatePrinter(Printer3D p) {
        this.printer3dDAO.updatePrinter(p);
    }
 
    @Override
    @Transactional
    public List<Printer3D> listPrinters() {
        return this.printer3dDAO.listPrinters();
    }
 
    @Override
    @Transactional
    public Printer3D getPrinterById(long id) {
        return this.printer3dDAO.getPrinterById(id);
    }
 
    @Override
    @Transactional
    public void removePrinter(long id) {
        this.printer3dDAO.removePrinter(id);
    }

	@Override
	@Transactional
	public Set<Printer3D> listSearchPrinters(SearchPrinters3D searchPrinters) {
		return this.printer3dDAO.listSearchPrinters(searchPrinters);
	}
 
}

