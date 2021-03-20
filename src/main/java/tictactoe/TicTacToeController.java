package tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tictactoe.model.Game;

@Controller
@SessionAttributes("game")
public class TicTacToeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index( @ModelAttribute("game" ) Game game ) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String markTile( 
			@ModelAttribute("game" ) Game game, 
			@RequestParam("tile_id") String tileId,
			@RequestParam(value = "new_game", required = false, defaultValue = "false") boolean newGame,
			@RequestParam(value = "player_go_first", required = false, defaultValue = "false") boolean playerGoFirst,
			@RequestParam(value = "board_length", required = false, defaultValue = "3") int boardLength
			) {
		
		if ( newGame ) {
			game.reset(boardLength);
			game.setPlayerGoFirst( playerGoFirst );
			if ( !playerGoFirst ) {
				if (boardLength <= 1)
				{
					game.markTile("0-0");
				}
				else
				game.markTile( "1-1" );
			}
		} else {
			game.markTile( tileId );
			game.markTileRandom();
		}
		
		return "index";
	}
	
	@ModelAttribute("game")
	public Game populateGame() {
		return new Game(3);
	}

}