package com.excelsus.createmodern;

import com.excelsus.createmodern.content.contraptions.components.centrifuge.CentrifugeTileEntity;
import com.simibubi.create.content.contraptions.components.millstone.MillStoneCogInstance;
import com.simibubi.create.content.contraptions.components.millstone.MillstoneRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class AllModernTileEntities {
	public static final BlockEntityEntry<CentrifugeTileEntity> CENTRIFUGE = CreateModern.registrate()
		.tileEntity("centrifuge", CentrifugeTileEntity::new)
		.instance(() -> MillStoneCogInstance::new, false)
		.validBlocks(AllModernBlocks.CENTRIFUGE)
		.renderer(() -> MillstoneRenderer::new)
		.register();

	public static void register() {}
}
