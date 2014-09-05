package com.example.moveporto;

import java.util.GregorianCalendar;

public class Passe {
	
	TipoPasse tipo;	
	double custo;
	GregorianCalendar dataCompra;
	GregorianCalendar dataExp;
	int tempoTotal;
	int id;
	User user;
	//int tempoRestante;
	
	public Passe(TipoPasse tipo, User user) {
		
		setTipo(tipo);
		setDataCompra();
		setDataExp();
		setTempoTotal();
		setUser(user);
		
	}

	

	public TipoPasse getTipo() {
		return tipo;
	}

	public double getCusto() {
		return custo;
	}

	public GregorianCalendar getDataCompra() {
		return dataCompra;
	}

	public GregorianCalendar getDataExp() {
		return dataExp;
	}

	public int getTempoTotal() {
		return tempoTotal;
	}
	
	public User getUser(){
		return user;
	}


	private void setTipo(TipoPasse tipo) {
		this.tipo = tipo;
	}

	private void setCusto() {
		switch (tipo) {
		case HOURLY:
			custo=1.20;
			break;
		case DAYLY:
			custo=4;	
			break;

		case WEEKLY:
			custo=20;
			break;

		case MONTHLY:
			custo=60;
			break;

		case YEARLY:
			custo=500;
			break;

		default:
			break;
		}
	}

	private void setDataCompra() {
		
		this.dataCompra = new GregorianCalendar();
	}

	
	private void setDataExp() {		
		
		switch (tipo) {
		case HOURLY:
			dataExp=dataCompra;
			dataExp.add(GregorianCalendar.HOUR_OF_DAY, 1);
			
			break;
		case DAYLY:
			dataExp=dataCompra;
			dataExp.add(GregorianCalendar.DAY_OF_MONTH, 1);
			break;

		case WEEKLY:
			dataExp=dataCompra;
			dataExp.add(GregorianCalendar.WEEK_OF_YEAR, 1);
			break;

		case MONTHLY:
			dataExp=dataCompra;
			dataExp.add(GregorianCalendar.MONTH, 1);
			break;

		case YEARLY:
			dataExp=dataCompra;
			dataExp.add(GregorianCalendar.YEAR, 1);
			break;

		default:
			dataExp=dataCompra;
			break;
		}
	}

	private void setTempoTotal() {
		switch (tipo) {
		case HOURLY:
			tempoTotal=60;
			break;
		case DAYLY:
			tempoTotal=1440;;	
			break;

		case WEEKLY:
			tempoTotal=10080;
			break;

		case MONTHLY:
			tempoTotal=43200;
			break;

		case YEARLY:
			tempoTotal=60;
			break;

		default:
			break;
		}
	}

	private String tempoRestante() {
		GregorianCalendar currenttime = new GregorianCalendar();
		GregorianCalendar tempoRestante = new GregorianCalendar(dataExp.YEAR-currenttime.YEAR,dataExp.MONTH-currenttime.MONTH,dataExp.DAY_OF_MONTH-currenttime.DAY_OF_MONTH,dataExp.HOUR_OF_DAY-currenttime.HOUR_OF_DAY,dataExp.MINUTE-currenttime.MINUTE);
		if (tempoRestante.MONTH!=0) {
			return tempoRestante.MONTH + " Months, " + tempoRestante.DAY_OF_MONTH + " Days, " + tempoRestante.HOUR_OF_DAY + " Hours, " + tempoRestante.MINUTE + " Minutes left...";
			
		}
		
		if (tempoRestante.DAY_OF_MONTH!=0) {
			return tempoRestante.DAY_OF_MONTH + " Days, " + tempoRestante.HOUR_OF_DAY + " Hours, " + tempoRestante.MINUTE + " Minutes left...";
			
		}
		
		if (tempoRestante.HOUR_OF_DAY!=0) {
			return tempoRestante.HOUR_OF_DAY + " Hours, " + tempoRestante.MINUTE + " Minutes left...";
			
		}
		
		else {
			return tempoRestante.MINUTE + " Minutes left...";
			
		}
		
	}
	
	private void setUser(User user) {
		this.user=user;		
	}
	
	
	
	

}
