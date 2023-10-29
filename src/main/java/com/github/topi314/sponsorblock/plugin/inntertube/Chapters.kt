package com.github.topi314.sponsorblock.plugin.inntertube

import kotlinx.serialization.Serializable

@Serializable
data class VideoRenderer(
    val videoId: String,
    val expandableMetadata: ExpandableMetadata? = null
)

@Serializable
data class ExpandableMetadata(val expandableMetadataRenderer: ExpandableMetadataRenderer)

@Serializable
data class ExpandableMetadataRenderer(val expandedContent: ExpandedContent)

@Serializable
data class ExpandedContent(val horizontalCardListRenderer: HorizontalCardListRenderer)

@Serializable
data class HorizontalCardListRenderer(
    val cards: List<Card>,
)

@Serializable
data class Card(
    val macroMarkersListItemRenderer: MacroMarkersListItemRenderer
)

@Serializable
data class MacroMarkersListItemRenderer(
    val title: TextBlock,
    val timeDescription: TextBlock,
)

@Serializable
data class TextBlock(val runs: List<Run> = emptyList()) {
    @Serializable
    data class Run(val text: String, val bold: Boolean = false)

    fun joinRuns() = runs.joinToString("", transform = Run::text)

    override fun toString(): String = joinRuns()
}

