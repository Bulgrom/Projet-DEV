package player;
import party.*;
import java.util.ArrayList;
import map.Character;
import map.Square;
import map.Status;
import ability.Ability;

public class HumanPlayer {
	private PartyInterface partyInterface;
	private ArrayList<Character> playableCharacters = new ArrayList<Character>();
	private Character currentCharacter;
	private boolean characterPlayed = false;
	private Party party;
	
	
	public HumanPlayer(PartyInterface partyInterface, ArrayList<Character> playableCharacters){
		this.partyInterface = partyInterface;
		party = partyInterface.getParty();
		this.playableCharacters = playableCharacters;
		this.currentCharacter = playableCharacters.get(0);
	}
	
	public Character getCurrentCharacter(){
		return currentCharacter;
	}
	
	public Character getPlayableCharacter(int index){
		return playableCharacters.get(index);
	}
	
	public void changeCharacter(Character character){
		if (!characterPlayed){
			if(playableCharacters.contains(character)) currentCharacter = character;
		}
		else System.out.println("You can't change, you've already played a character");
	}
	
	public void move(Square square){
		currentCharacter.move(square);
		characterPlayed = true;
		if(currentCharacter.isDead()){
			party.getOrder().remove(currentCharacter);
			endTurn();
		}
	}
	
	public void useAction(Ability ability, Square square){
		currentCharacter.useAbility(ability, square);
		if(square.getCharacter().getStatus() == Status.DEAD) party.getOrder().remove(square.getCharacter());
		characterPlayed = true;
		if(currentCharacter.isDead()){
			party.getOrder().remove(currentCharacter);
			endTurn();
		}
	}
	
	public void endTurn(){
		currentCharacter.incPlayTime();
		currentCharacter.resetMovement();
		currentCharacter.resetAction();
		currentCharacter.resetPv();
		if(currentCharacter.isDead()){
			party.getOrder().remove(currentCharacter);
		}
		partyInterface.endTurn(currentCharacter);
	}
	
}
