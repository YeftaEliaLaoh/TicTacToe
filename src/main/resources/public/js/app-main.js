$( document ).ready( function() {
	
	if( $( "#is_game_over" ).val() !== "true" ) {
		$( ".board-row-tile.available" ).click( function( event ) {
			$( "#tile_id" ).val( event.target.id );
			$( "#form_mark_tile" ).submit();
		} );
	}
	
	$( "#btn-new-game" ).click( function( event ) {
		if($('#board_length').val() < 3)
		{
		    $('#board_length').val(3);
		}
		$( "#new_game" ).val( "yes" );
		$( "#form_mark_tile" ).submit();
	} );

    $('#board_length').keyup(function () {
        this.value = this.value.replace(/[^0-9\.]/g,'');
    });

     $('#board_length').keydown(function () {
         if (event.which == 13) {
            $( "#new_game" ).val( "yes" );
                if($('#board_length').val() < 3)
                        {
                            $('#board_length').val(3);
                        }
             }
     });

} );