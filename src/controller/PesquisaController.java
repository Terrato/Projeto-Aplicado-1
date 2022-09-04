package controller;

import java.util.List;

import dao.PesquisaDao;
import interfaces.Crud;
import model.Pesquisa;

public class PesquisaController implements Crud<Pesquisa> {

	@Override
	public void Create(Pesquisa t) throws Exception {
		if (t.getId() < 0)
			throw new Exception(ErrorMessages.ID_ERROR);
		
		if (t.getLocal().length() < 1 || t.getLocal().length() > 50)
			throw new Exception(ErrorMessages.LOCATION_ERROR);
		
		if (t.getInstituto().length() < 1 || t.getInstituto().length() > 50)
			throw new Exception(ErrorMessages.INSTITUTE_ERROR);
		
		if (t.getFormato().length() < 1 || t.getFormato().length() > 10)
			throw new Exception(ErrorMessages.FORMAT_ERROR);
		
		PesquisaDao.getInstance().Create(t);
		System.out.println("Pesquisa " + t.getId() + " criada com sucesso.");
	}

	@Override
	public List<Pesquisa> Read() {
		return PesquisaDao.getInstance().Read();
	}

	@Override
	public void Update(Pesquisa t) throws Exception {
		PesquisaDao.getInstance().Update(t);
	}

	@Override
	public void Delete(Pesquisa t) throws Exception {
		PesquisaDao.getInstance().Delete(t);
	}

}