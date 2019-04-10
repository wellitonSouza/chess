package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1 ) {
			throw new BoardException("Erro ao criar tabuleiro : O valor não pode ser menor que 1");
		}
		this.rows = rows;
		this.columns = columns;
		pieces  = new Piece[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public int getColumn() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não encontrada no tabuleiro!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existem uma peça na posição "+ position);
		}
		pieces[position.getRow()][position.getColumn()]= piece;
		piece.position = position;
	}
	
	public boolean positionExists(int row, int column) {
		
		return rows >=0  && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não encontrada no tabuleiro!");
		}
		return piece(position) != null;
	}
	
}
